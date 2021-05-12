package controller;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Sent when an employee attempts to login as a customer
 */
public class LoginAsCustomerMessage implements Message {
    private JFrame frame;
    private BlockingQueue<Message> queue;
    private int size;
    private String username;

    /**
     * Constructor for LoginAsCustomerMessage
     * @param frame the frame of the current view
     * @param queue the queue of messages
     * @param size the size of the frame
     * @param username the customer's username
     */
    public LoginAsCustomerMessage(JFrame frame, BlockingQueue<Message> queue, int size, String username) {
        this.frame = frame;
        this.queue = queue;
        this.size = size;
        this.username = username;
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
     * Getter for the size of the view
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter for the customer's username
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}
