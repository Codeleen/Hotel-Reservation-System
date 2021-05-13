package controller;

import model.*;
import view.CustomerMenuScreen;
import view.CustomerViewReservationScreen;
import view.LoginScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Acts upon the model and view and keeps them separate by controlling the data
 * that flows into the model and updating the view whenever data changes.
 */
public class Controller {
    private BlockingQueue<Message> queue;
    private HotelSystem model;
    private LoginScreen view;
    private List<Valve> valves = new LinkedList<Valve>();

    /**
     * Constructor for the controller, initializing its class variables and adding the valves
     * to its valves list.
     * @param queue the queue of messages sent from views.
     * @param model the object of class HotelSystem.
     * @param view the object of class LoginScreen.
     */
    public Controller(BlockingQueue<Message> queue, HotelSystem model, LoginScreen view) {
        this.queue = queue;
        this.model = model;
        this.view = view;

        valves.add(new DoCreateNewCustomerValve());
        valves.add(new DoLoginCustomerValve());
        valves.add(new DoCreateNewReservationValve());
        valves.add(new DoLoginAsCustomerValve());
        valves.add(new DoViewReservationListValve());
        valves.add(new DoCancelReservationValve());
    }

    /**
     * Processes the messages that come into the queue through each of the
     * available valves until there is a match.
     */
    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Valve valve : valves) {
                response = valve.execute(message);
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    /**
     * Converts an ArrayList of Reservations into an array of Strings needed for
     * JList.
     * @param reservations the ArrayList of reservations.
     * @return an array of Strings with the proper output.
     */
    private String[] getDataToBePrinted(ArrayList<Reservation> reservations) {
        ArrayList<String> dataToBePrinted = new ArrayList<>();
        String startDate;
        String endDate;
        String roomNumber;
        double price;

        for (Reservation reservation : reservations) {
            startDate = reservation.getDatePeriod().getStart().toString();
            endDate = reservation.getDatePeriod().getEnd().toString();
            roomNumber = reservation.getRoomNumber();
            price = reservation.getPrice();
            dataToBePrinted.add("Room " + roomNumber + " = $" + String.format("%.2f", price) + ": " +
                    startDate + " - " + endDate);
        }

        String[] newDataToBePrinted = new String[dataToBePrinted.size()];
        return dataToBePrinted.toArray(newDataToBePrinted);
    }

    /**
     * Valve for CreateNewCustomer message.
     */
    private class DoCreateNewCustomerValve implements Valve {
        /**
         * Creates a customer object and adds it to hotel system's customers hashmap.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != CreateNewCustomerMessage.class) {
                return ValveResponse.MISS;
            }

            CreateNewCustomerMessage classMessage = (CreateNewCustomerMessage) message;
            model.addCustomer(new Customer(classMessage.getName(), classMessage.getUsername(),
                    classMessage.getPassword()));
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve for LoginCustomerMessage.
     */
    private class DoLoginCustomerValve implements Valve {
        /**
         * Gets a customer from the provided username and password, then sends the user
         * to the customer menu screen if the customer exists.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != LoginCustomerMessage.class) {
                return ValveResponse.MISS;
            }

            LoginCustomerMessage classMessage = (LoginCustomerMessage) message;
            Customer customer = model.getCustomer(classMessage.getUsername(), classMessage.getPassword());

            if (customer != null) {
                JFrame frame = classMessage.getFrame();
                frame.dispose();
                new CustomerMenuScreen(classMessage.getQueue(), classMessage.getSize(), customer);
            } else {
                JOptionPane.showMessageDialog(
                        null, "Username or Password is invalid.");
            }
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve for CreateNewReservationMessage.
     */
    private class DoCreateNewReservationValve implements Valve {
        /**
         * Creates a new reservation and adds it to a particular customer's list of reservations.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != CreateNewReservationMessage.class) {
                return ValveResponse.MISS;
            }

            CreateNewReservationMessage classMessage = (CreateNewReservationMessage) message;
            DatePeriod datePeriod = new DatePeriod(classMessage.getStartDate(), classMessage.getEndDate());
            Reservation reservation = new NormalReservation(classMessage.getRoom(), datePeriod);

            if (classMessage.getIsDiscounted()) {
                reservation = new Discount(reservation);
            }
            if (classMessage.getHasLuxury()) {
                reservation = new LuxuryAmenities(reservation);
            }

            Customer customer = classMessage.getCustomer();
            customer.addReservation(reservation);

            JFrame frame = classMessage.getFrame();
            frame.dispose();
            new CustomerMenuScreen(classMessage.getQueue(), classMessage.getSize(), customer);

            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve for LoginAsCustomerMessage.
     */
    private class DoLoginAsCustomerValve implements Valve {
        /**
         * Gets a customer from the provided username, then sends the user
         * to the customer menu screen if the customer exists.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != LoginAsCustomerMessage.class) {
                return ValveResponse.MISS;
            }

            LoginAsCustomerMessage classMessage = (LoginAsCustomerMessage) message;
            Customer customer = model.getCustomer(classMessage.getUsername());

            if (customer != null) {
                JFrame frame = classMessage.getFrame();
                frame.dispose();
                new CustomerMenuScreen(classMessage.getQueue(), classMessage.getSize(), customer);
            } else {
                JOptionPane.showMessageDialog(
                        null, "Username is invalid.");
            }
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve for ViewReservationListMessage.
     */
    private class DoViewReservationListValve implements Valve {
        /**
         * Builds the output of reservation details needed for JList.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != ViewReservationListMessage.class) {
                return ValveResponse.MISS;
            }

            ViewReservationListMessage classMessage = (ViewReservationListMessage) message;
            ArrayList<Reservation> reservations = classMessage.getCustomer().getReservations();
            classMessage.getFrame().dispose();
            new CustomerViewReservationScreen(classMessage.getQueue(), classMessage.getSize(),
                    classMessage.getCustomer(), getDataToBePrinted(reservations));

            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve for CancelReservationMessage
     */
    private class DoCancelReservationValve implements Valve {
        /**
         * Cancels a particular reservation, then builds the updated output needed
         * for JList to update.
         * @param message the message to be checked for a match.
         * @return a "miss" if there was no match and an "executed" if there was.
         */
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != CancelReservationMessage.class) {
                return ValveResponse.MISS;
            }

            CancelReservationMessage classMessage = (CancelReservationMessage) message;
            int index = classMessage.getReservationList().getSelectedIndex();
            classMessage.getCustomer().cancelReservation(index);
            ArrayList<Reservation> reservations = classMessage.getCustomer().getReservations();

            classMessage.getFrame().dispose();
            new CustomerViewReservationScreen(classMessage.getQueue(), classMessage.getSize(),
                    classMessage.getCustomer(), getDataToBePrinted(reservations));

            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Interface allowing for list of valves to accept any kind of valve.
     */
    private interface Valve {
        /**
         * Performs an action upon matching the right message.
         */
        public ValveResponse execute(Message message);
    }
}
