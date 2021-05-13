package view;

import controller.Message;
import controller.ViewReservationListMessage;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see after successfully logging in as a customer.
 */
public class CustomerMenuScreen extends JFrame {
    /**
     * Constructor for CustomerMenuScreen, creates buttons for user to create a reservation
     * or view/cancel his or her reservation(s).
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     * @param customer the particular customer that is logged-in.
     */
    public CustomerMenuScreen(BlockingQueue<Message> queue, int size, Customer customer) {
        JFrame frame = this;
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        Font largeFont = new Font("SansSerif", Font.PLAIN, size / 30);

        JLabel title = new JLabel("Welcome Customer");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, size / 10));
        title.setPreferredSize(new Dimension(size, size / 3));

        JButton newReservationButton = new JButton("Make a reservation");
        newReservationButton.setPreferredSize(new Dimension(size / 2, size / 6));
        newReservationButton.addActionListener(e -> {
            dispose();
            new CustomerNewReservationScreen(queue, size, customer);
        });
        newReservationButton.setPreferredSize(new Dimension(size/2, size/6));
        newReservationButton.setFont(largeFont);
        newReservationButton.setFocusable(false);

        JButton viewReservationButton = new JButton("View / Cancel reservation");
        viewReservationButton.addActionListener(e -> {
            try {
                Message message = new ViewReservationListMessage(frame, queue, size, customer);
                queue.put(message);
            } catch(InterruptedException exception) {
                //do nothing
            }
        });
        viewReservationButton.setPreferredSize(new Dimension(size / 2, size / 6));
        viewReservationButton.setFont(largeFont);
        viewReservationButton.setFocusable(false);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new LoginScreen(queue, size);
        });
        backButton.setPreferredSize(new Dimension(size / 2, size / 6));
        backButton.setFont(largeFont);
        backButton.setFocusable(false);

        JPanel buttons = new JPanel();
        buttons.add(newReservationButton);
        buttons.add(viewReservationButton);
        buttons.add(backButton);

        add(title);
        add(buttons);

        setTitle("Customer Menu");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
