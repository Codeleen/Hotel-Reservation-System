package controller;

import model.Customer;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;

/**
 * Sent when an attempt to create a new reservation is made
 */
public class CreateNewReservationMessage implements Message {
    private JFrame frame;
    private BlockingQueue<Message> queue;
    private int size;
    private Customer customer;
    private String room;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructor for CreateNewReservationMessage
     * @param frame the frame of the current view
     * @param queue the queue of messages
     * @param size the size of the frame
     * @param customer the logged-in customer
     * @param room the room number
     * @param startDate the starting date of reservation
     * @param endDate the ending date of reservation
     */
    public CreateNewReservationMessage(JFrame frame, BlockingQueue<Message> queue, int size, Customer customer, String room,
                                       String startDate, String endDate) {
        this.frame = frame;
        this.queue = queue;
        this.size = size;
        this.customer = customer;
        this.room = room;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        this.startDate = LocalDate.parse(startDate, formatter);
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    /**
     * Getter for the frame of the view
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Getter for the queue of messages
     * @return the queue
     */
    public BlockingQueue<Message> getQueue() {
        return queue;
    }

    /**
     * Getter for the size of view
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter for the logged-in customer
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Getter for the room number for reservation
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Getter for the reservation's starting date
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Getter for the reservation's ending date
     * @return the end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }
}
