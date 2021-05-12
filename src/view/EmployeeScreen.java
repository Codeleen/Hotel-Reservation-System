package view;

import controller.LoginAsCustomerMessage;
import controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen an employee will see
 */
public class EmployeeScreen extends JFrame {
    /**
     * Constructor for EmployeeScreen, creates text fields for employee to login as customer
     * @param queue the queue of messages for controller to handle
     * @param size the size used for scaling components
     */
    public EmployeeScreen(BlockingQueue<Message> queue, int size) {
        JFrame frame = this;
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome Employee");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, size / 10));
        title.setPreferredSize(new Dimension(size, size / 3));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 2));

        JLabel loginAsCustomerLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);
        JButton loginAsCustomerButton = new JButton("Login as Customer");
        loginAsCustomerButton.addActionListener(e -> {
                String username = usernameTextField.getText();
                try {
                    Message message = new LoginAsCustomerMessage(frame, queue, size, username);
                    queue.put(message);
                } catch (InterruptedException exception) {
                    //do nothing
                }
        });

        JButton quitButton = new JButton("Back");
        quitButton.addActionListener(e -> {
                frame.dispose();
                new LoginScreen(queue, size);
        });

        loginPanel.add(loginAsCustomerLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(new JLabel(""));

        add(title);
        add(loginPanel);
        add(loginAsCustomerButton);
        add(quitButton);

        setTitle("Hotel Reservation System");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}