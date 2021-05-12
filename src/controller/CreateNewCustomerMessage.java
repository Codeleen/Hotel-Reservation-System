package controller;

/**
 * Sent when an attempt to create a new customer is made
 */
public class CreateNewCustomerMessage implements Message {
    private String name;
    private String username;
    private String password;

    /**
     * Constructor for CreateNewCustomerMessage
     * @param name the name of the customer
     * @param username the username for logging in
     * @param password the password for logging in
     */
    public CreateNewCustomerMessage(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for new customer's name
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for new customer's username
     * @return the customer's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for new customer's password
     * @return the customer's password
     */
    public String getPassword() {
        return password;
    }
}
