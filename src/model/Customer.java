package model;

import java.util.ArrayList;

/**
 * A class modeling a customer in a hotel reservation system.
 */
public class Customer {
    private String name;
    private String username;
    private String password;
    private ArrayList<Reservation> reservations;

    /**
     * Constructs a customer who can have his or her own reservations.
     * @param name the name of the customer.
     * @param username the username the customer chooses for logging in.
     * @param password the password the customer chooses for logging in.
     */
    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        reservations = new ArrayList<>();
    }

    /**
     * Getter for the username.
     * @return the customer's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for the reservations ArrayList.
     * @return the list of the customer's reservations.
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Adds a reservation to a customer's reservations ArrayList.
     * @param reservation the reservation to be added.
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Cancels a reservation, removing it from the customer's reservations ArrayList.
     * @param index the index of the reservation to be removed.
     */
    public void cancelReservation(int index) {
        reservations.remove(index);
    }

    /**
     * Checks if the password in parameter matches customer's password.
     * @param password the password to be checked.
     * @return true if the password matches, false otherwise.
     */
    public boolean validatePassword(String password) {
        return password.equals(this.password);
    }
}
