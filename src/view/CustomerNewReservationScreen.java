package view;

import controller.CreateNewReservationMessage;
import controller.Message;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when creating a new reservation as a customer
 */
public class CustomerNewReservationScreen extends JFrame {
    /**
     * Constructor for CustomerNewReservation, creates fields for the customer to fill out to
     * create a new reservation
     * @param queue the queue of messages for controller to handle
     * @param size the size used for scaling components
     * @param customer the particular customer that is logged-in
     */
    public CustomerNewReservationScreen(BlockingQueue<Message> queue, int size, Customer customer) {
        JFrame frame = this;
        this.setTitle("New Reservation");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("New Reservation");

        JPanel newReservationPanel = new JPanel();
        newReservationPanel.setLayout(new GridLayout(3, 2));

        JLabel roomLabel = new JLabel("Room:");
        JTextField roomTextField = new JTextField(16);
        JLabel startDateLabel = new JLabel("Start Date:");
        JTextField startDateTextField = new JTextField(16);
        JLabel endDateLabel = new JLabel("End Date:");
        JTextField endDateTextField = new JTextField(16);

        newReservationPanel.add(roomLabel);
        newReservationPanel.add(roomTextField);
        newReservationPanel.add(startDateLabel);
        newReservationPanel.add(startDateTextField);
        newReservationPanel.add(endDateLabel);
        newReservationPanel.add(endDateTextField);

        JButton newReservationButton = new JButton("Confirm");
        newReservationButton.addActionListener(e -> {
            String room = roomTextField.getText();
            String startDate = startDateTextField.getText();
            String endDate = endDateTextField.getText();

            if (!room.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty()) {
                try {
                    Message message = new CreateNewReservationMessage(frame, queue, size, customer, room,
                            startDate, endDate);
                    queue.put(message);
                } catch (InterruptedException exception) {
                    //do nothing
                }
            } else {
                JOptionPane.showMessageDialog(
                        null, "Please fill out all fields ");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new CustomerMenuScreen(queue, size, customer);
        });

        this.add(title, BorderLayout.NORTH);
        this.add(newReservationPanel, BorderLayout.CENTER);
        this.add(newReservationButton, BorderLayout.SOUTH);
        this.add(backButton, BorderLayout.SOUTH);

        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400, 300);
    }
}
