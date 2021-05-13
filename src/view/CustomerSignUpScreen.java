package view;

import controller.CreateNewCustomerMessage;
import controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when trying to create a customer account.
 */
public class CustomerSignUpScreen extends JFrame {
    /**
     * Constructor for CustomerSignUpScreen, creates text fields for signing up for a
     * customer account.
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     */
    public CustomerSignUpScreen(BlockingQueue<Message> queue, int size) {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Customer Sign Up");
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.PLAIN, size / 10));
        title.setPreferredSize(new Dimension(size, size / 3));

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayout(4, 2));
        JLabel idLabel = new JLabel("Name:");
        JTextField idField = new JTextField("Tom", 20);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField("Tom123", 20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField( 20);

        signUpPanel.add(idLabel);
        signUpPanel.add(idField);
        signUpPanel.add(usernameLabel);
        signUpPanel.add(usernameField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(
                e -> {
                    String id = idField.getText();
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    if (!id.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                        try {
                            Message message = new CreateNewCustomerMessage(id, username, password);
                            queue.put(message);
                        } catch (InterruptedException exception) {
                            //do nothing
                        }
                        this.dispose();
                        new CustomerScreen(queue, size);
                    } else {
                        JOptionPane.showMessageDialog(
                                null, "Please fill out all fields ");
                    }
                });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new CustomerScreen(queue, size);
        });

        add(title, BorderLayout.NORTH);
        add(signUpPanel, BorderLayout.CENTER);
        add(signUpButton, BorderLayout.SOUTH);
        add(backButton, BorderLayout.SOUTH);

        setTitle("Sign Up");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
