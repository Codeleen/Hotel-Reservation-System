package controller;

import model.Customer;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Sent whenever an attempt is made by a customer to view his or her reservations.
 */
public class ViewReservationListMessage implements Message {
    private JFrame frame;
    private BlockingQueue<Message> queue;
    private int size;
    private Customer customer;

    /**
     * Constructor for ViewReservationListMessage.
     * @param frame the frame of the current view.
     * @param queue the queue of messages.
     * @param size the size of the frame.
     * @param customer the particular logged-in customer.
     */
    public ViewReservationListMessage(JFrame frame, BlockingQueue<Message> queue, int size,
                                      Customer customer) {
        this.frame = frame;
        this.queue = queue;
        this.size = size;
        this.customer = customer;
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
     * Getter for the size of the frame.
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
}
