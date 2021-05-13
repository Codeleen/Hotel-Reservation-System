package view;

import controller.CreateNewReservationMessage;
import controller.Message;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when creating a new reservation as a customer.
 */
public class CustomerNewReservationScreen extends JFrame {
    /**
     * Constructor for CustomerNewReservation, creates fields for the customer to fill out to
     * create a new reservation.
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     * @param customer the particular customer that is logged-in.
     */
    public CustomerNewReservationScreen(BlockingQueue<Message> queue, int size, Customer customer) {
        JFrame frame = this;
        this.setTitle("New Reservation");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("New Reservation");

        JPanel newReservationPanel = new JPanel();
        newReservationPanel.setLayout(new GridLayout(4, 2));

        JLabel roomLabel = new JLabel("Room:");
        JTextField roomTextField = new JTextField(16);
        JLabel startDateLabel = new JLabel("Start Date:");
        JTextField startDateTextField = new JTextField(16);
        JLabel endDateLabel = new JLabel("End Date:");
        JTextField endDateTextField = new JTextField(16);

        JPanel checkboxes = new JPanel(new FlowLayout());
        JCheckBox discountCheckbox = new JCheckBox("Discounted");
        JCheckBox luxuryCheckbox = new JCheckBox("Luxury Amenities");
        checkboxes.add(discountCheckbox);
        checkboxes.add(luxuryCheckbox);

        newReservationPanel.add(roomLabel);
        newReservationPanel.add(roomTextField);
        newReservationPanel.add(startDateLabel);
        newReservationPanel.add(startDateTextField);
        newReservationPanel.add(endDateLabel);
        newReservationPanel.add(endDateTextField);
        newReservationPanel.add(checkboxes);

        JButton newReservationButton = new JButton("Confirm");
        newReservationButton.addActionListener(e -> {
            String room = roomTextField.getText();
            String startDate = startDateTextField.getText();
            String endDate = endDateTextField.getText();

            if (!room.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty()) {
                boolean discounted = discountCheckbox.isSelected();
                boolean hasLuxury = luxuryCheckbox.isSelected();

                try {
                    Message message = new CreateNewReservationMessage(frame, queue, size, customer, room,
                            startDate, endDate, discounted, hasLuxury);
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

        add(title, BorderLayout.NORTH);
        add(newReservationPanel, BorderLayout.CENTER);
        add(newReservationButton, BorderLayout.SOUTH);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
