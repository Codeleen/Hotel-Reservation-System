package controller;

import model.Customer;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Sent when an attempt to cancel a reservation is made.
 */
public class CancelReservationMessage implements Message {
    private JFrame frame;
    private BlockingQueue<Message> queue;
    private int size;
    private Customer customer;
    private JList reservationList;

    /**
     * Constructor for CancelReservationMessage.
     * @param frame the frame of the current view.
     * @param queue the queue of messages.
     * @param size the size used for scaling components.
     * @param customer the particular logged-in customer.
     * @param reservationList the view's JList of reservations.
     */
    public CancelReservationMessage(JFrame frame, BlockingQueue<Message> queue, int size, Customer customer,
                                    JList reservationList) {
        this.frame = frame;
        this.queue = queue;
        this.size = size;
        this.customer = customer;
        this.reservationList = reservationList;
    }

    /**
     * Getter for the frame of the current view.
     * @return the frame.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Getter for the queue of messages.
     * @return the queue.
     */
    public BlockingQueue<Message> getQueue() {
        return queue;
    }

    /**
     * Getter for the size used for scaling.
     * @return the size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter for the particular logged-in customer.
     * @return the customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Getter for the JList of reservations from the view.
     * @return the JList.
     */
    public JList getReservationList() {
        return reservationList;
    }
}
