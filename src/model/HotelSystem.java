package model;

import java.util.*;

public class HotelSystem {
    private Map<String, Customer> customers;

    /**
     * Constructor for HotelSystem, initializing the customers hashmap
     */
    public HotelSystem() {
        customers = new HashMap<>();
    }

    /**
     * Adds a customer to the hashmap, first checking if that customer already
     * exists
     * @param customer the customer to be added
     */
    public void addCustomer(Customer customer) {
        String username = customer.getUsername();
        if (customerExists(username))
            throw new IllegalStateException("The specified customer already exists!");
        customers.put(username, customer);
    }

    /**
     * Getter for the customers hashmap
     * @return the customers hashmap
     */
    public Map<String, Customer> getCustomers() {
        return customers;
    }

    /**
     * Checks if a customer already exists
     * @param username the username of the customer
     * @return true if the customer already exists in the customers hashmap, false otherwise
     */
    public boolean customerExists(String username) {
        return customers.containsKey(username);
    }

    /**
     * Getter for a particular customer from the customers hashmap, used when a customer
     * tries to log in
     * @param username the username the customer entered
     * @param password the password the customer entered
     * @return a Customer object if both the username and password are correct and null otherwise
     */
    public Customer getCustomer(String username, String password) {
        Customer customer = customers.get(username);
        return customer != null && customer.validatePassword(password) ? customer : null;
    }

    /**
     * Getter for a particular customer from the customers hashmap, used when an employee
     * logs in as a customer
     * @param username the username the employee entered
     * @return a Customer object if there exists a customer with that username and null otherwise
     */
    public Customer getCustomer(String username) {
        Customer customer = customers.get(username);
        return customer;
    }
}
