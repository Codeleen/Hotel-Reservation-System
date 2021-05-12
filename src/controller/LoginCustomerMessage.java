package controller;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;

/**
 * Sent when a customer attempts to login
 */
public class LoginCustomerMessage implements Message {
    private JFrame frame;
    private BlockingQueue<Message> queue;
    private int size;
    private String username;
    private String password;

    /**
     * Constructor for LoginCustomerMessage
     * @param frame the frame of the current view
     * @param queue the queue of messages
     * @param size the size of the frame
     * @param username the customer's username
     * @param password the customer's password
     */
    public LoginCustomerMessage(JFrame frame, BlockingQueue<Message> queue, int size, String username, String password) {
        this.frame = frame;
        this.queue = queue;
        this.size = size;
        this.username = username;
        this.password = password;
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
     * Getter for the size of the frame
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

    /**
     * Getter for the customer's password
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
