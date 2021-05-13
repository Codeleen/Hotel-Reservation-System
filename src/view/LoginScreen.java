package view;

import controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the initial screen all users will see.
 */
public class LoginScreen extends JFrame {
    /**
     * Constructor for LoginScreen, creates two buttons, one for employee and the
     * other for customer.
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     */
    public LoginScreen(BlockingQueue<Message> queue, int size) {
        Font largeFont = new Font("Serif", Font.PLAIN, size / 5);
        Font smallFont = new Font("SansSerif", Font.PLAIN, size / 12);

        JLabel welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(largeFont);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel label = new JLabel("Sign in as:");
        label.setFont(smallFont);

        JButton employeeButton = new JButton("Employee");
        employeeButton.addActionListener(e -> {
            dispose();
            new EmployeeScreen(queue, size);
        });
        employeeButton.setPreferredSize(new Dimension(size/2, size/6));
        employeeButton.setFont(smallFont);
        employeeButton.setFocusable(false);

        JButton customerButton = new JButton("Customer");
        customerButton.addActionListener(e -> {
                dispose();
                new CustomerScreen(queue, size);
        });
        customerButton.setPreferredSize(new Dimension(size/2, size/6));
        customerButton.setFont(smallFont);
        customerButton.setFocusable(false);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(employeeButton);
        panel.add(customerButton);
        panel.setLayout(new GridLayout(1, 3, 10, 10));

        add(welcomeLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);

        setTitle("Hotel Reservation System");
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
