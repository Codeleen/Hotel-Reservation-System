import model.Customer;
import model.HotelSystem;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the HotelSystem model class
 */
public class HotelSystemTest {
    /**
     * Tests if addCustomer() works by seeing if the customers hashmap afterwards is equal to a
     * different instance of the same data structure after the same addition
     */
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("Tom", "Tom123", "password");
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.addCustomer(customer);

        Map<String, Customer> customers = new HashMap<>();
        customers.put("Tom123", customer);

        assertEquals(customers, hotelSystem.getCustomers(), "Should add one customer");
    }

    /**
     * Tests if addCustomer() throws an exception when trying to add a customer with a username that
     * is already being used
     */
    @Test
    public void testAddCustomerException() {
        Customer customer1 = new Customer("Tom", "Tom123", "password");
        Customer customer2 = new Customer("Tommy", "Tom123", "password");
        HotelSystem hotelSystem = new HotelSystem();

        hotelSystem.addCustomer(customer1);

        assertThrows(IllegalStateException.class, () -> {
            hotelSystem.addCustomer(customer2);
        }, "Should throw IllegalStateException");
    }

    /**
     * Tests if getCustomer() works by creating a customer, adding it, then retrieving it and checking
     * if it is equal to the original
     */
    @Test
    public void testGetCustomer() {
        Customer customer = new Customer("Tom", "Tom123", "password");
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.addCustomer(customer);

        assertEquals(customer, hotelSystem.getCustomer("Tom123", "password"),
                "Should get the customer with username Tom123");
    }
}
