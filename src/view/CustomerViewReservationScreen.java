package view;

import controller.Message;
import model.Customer;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when viewing reservations as a customer
 */
public class CustomerViewReservationScreen extends JFrame {
    /**
     * Constructor for CustomerViewReservationScreen, creates a JList of the reservations
     * @param queue the queue of messages for controller to handle
     * @param size the size used for scaling components
     * @param customer the particular logged-in customer
     */
    public CustomerViewReservationScreen(BlockingQueue<Message> queue, int size, Customer customer) {
        JScrollPane scrollPane = new JScrollPane();
        JList reservationList = new JList(getReservationList(customer));
        reservationList.setSelectedIndex(0);
        scrollPane.getViewport().setView(reservationList);
        scrollPane.setPreferredSize(new Dimension(200, 80));
        JPanel listPanel = new JPanel();
        listPanel.add(scrollPane);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            int index = reservationList.getSelectedIndex();
            customer.cancelReservation(index);
            new CustomerViewReservationScreen(queue, size, customer);
            dispose();
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new CustomerMenuScreen(queue, size, customer);
        });

        listPanel.add(cancelButton);
        listPanel.add(backButton);
        listPanel.setLayout(new GridLayout(1, 3, 10, 10));
        listPanel.setSize(200, 200);
        this.add(listPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Getter for a particular customer's reservation list suitable to be used in a JList
     * @param customer the particular logged-in customer
     * @return customer's reservations
     */
    public String[] getReservationList(Customer customer) {
        return customer.getReservations().stream()
                .map(Reservation::getDatePeriod)
                .map(i -> String.format("%s - %s", i.getStart().toString(), i.getEnd().toString()))
                .toArray(String[]::new);
    }
}
