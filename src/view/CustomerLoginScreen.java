package view;

import controller.Message;
import controller.LoginCustomerMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when logging in as a customer
 */
public class CustomerLoginScreen extends JFrame {
    /**
     * Constructor for CustomerLoginScreen, creates fields for customer to use to login
     * @param queue the queue of messages for controller to handle
     * @param size the size of used for scaling components
     */
    public CustomerLoginScreen(BlockingQueue<Message> queue, int size) {
        JFrame frame = this;
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Customer Login");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, size / 10));
        title.setPreferredSize(new Dimension(size, size / 3));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField( 20);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(
                e -> {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (!username.isEmpty() && !password.isEmpty()) {
                        try {
                            Message message = new LoginCustomerMessage(frame, queue, size, username, password);
                            queue.put(message);
                        } catch (InterruptedException exception) {
                            //do nothing
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "Please fill out all fields.");
                    }
                });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new CustomerScreen(queue, size);
        });

        add(title);
        add(loginPanel);
        add(loginButton);
        add(backButton);

        setTitle("Login");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
