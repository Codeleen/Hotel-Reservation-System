package view;

import controller.CancelReservationMessage;
import controller.Message;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * Defines the screen the user will see when viewing reservations as a customer.
 */
public class CustomerViewReservationScreen extends JFrame {
    /**
     * Constructor for CustomerViewReservationScreen, creates a JList of the reservations.
     * @param queue the queue of messages for controller to handle.
     * @param size the size used for scaling components.
     * @param customer the particular logged-in customer.
     * @param dataToBePrinted the data to be used in JList for showing output.
     */
    public CustomerViewReservationScreen(BlockingQueue<Message> queue, int size, Customer customer,
                                         String[] dataToBePrinted) {
        JFrame frame = this;
        JScrollPane scrollPane = new JScrollPane();
        JList reservationList = new JList(dataToBePrinted);
        reservationList.setSelectedIndex(0);
        scrollPane.getViewport().setView(reservationList);
        scrollPane.setPreferredSize(new Dimension(200, 80));
        JPanel listPanel = new JPanel();
        listPanel.add(scrollPane);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(size / 2, size / 6));
        cancelButton.addActionListener(e -> {
            try {
                Message message = new CancelReservationMessage(frame, queue, size, customer, reservationList);
                queue.put(message);
            } catch(InterruptedException exception) {
                //do nothing
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(size / 2, size / 6));
        backButton.addActionListener(e -> {
            dispose();
            new CustomerMenuScreen(queue, size, customer);
        });

        listPanel.add(cancelButton);
        listPanel.add(backButton);
        listPanel.setLayout(new GridLayout(1, 3, 10, 10));
        listPanel.setSize(200, 200);
        add(listPanel);

        setTitle("View/Cancel Reservation");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
