package view;

import controller.Message;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see after choosing to view the application as a customer.
 */
public class CustomerScreen extends JFrame {
    /**
     * Constructor for CustomerScreen, creates buttons to login or signup for an account.
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     */
    public CustomerScreen(BlockingQueue<Message> queue, int size) {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        JPanel titleContainer = new JPanel();
        Font largeFont = new Font("SansSerif", Font.PLAIN, size / 13);

        JLabel title = new JLabel("Welcome Customer");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, size / 10));
        title.setPreferredSize(new Dimension(size, size / 3));
        titleContainer.add(title);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(size / 2, size / 6));
        loginButton.addActionListener(e -> {
            dispose();
            new CustomerLoginScreen(queue, size);
        });
        loginButton.setPreferredSize(new Dimension(size/2, size/6));
        loginButton.setFont(largeFont);
        loginButton.setFocusable(false);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(size / 2, size / 6));
        signupButton.addActionListener(e -> {
            dispose();
            new CustomerSignUpScreen(queue, size);
        });
        signupButton.setPreferredSize(new Dimension(size/2, size/6));
        signupButton.setFont(largeFont);
        signupButton.setFocusable(false);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(size / 2, size / 6));
        backButton.addActionListener(e -> {
            dispose();
            new LoginScreen(queue, size);
        });
        backButton.setPreferredSize(new Dimension(size/2, size/6));
        backButton.setFont(largeFont);
        backButton.setFocusable(false);

        JPanel buttons = new JPanel();
        buttons.add(loginButton);
        buttons.add(signupButton);
        buttons.add(backButton);

        add(titleContainer);
        add(buttons);

        setTitle("Hotel Reservation System");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
