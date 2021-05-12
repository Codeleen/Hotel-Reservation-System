import model.Customer;
import model.HotelSystem;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelSystemTest {
    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("Tom", "Tom123", "password");
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.addCustomer(customer);

        Map<String, Customer> customers = new HashMap<>();
        customers.put("Tom123", customer);

        assertEquals(customers, hotelSystem.getCustomers(), "Should add one customer");
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer("Tom", "Tom123", "password");
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.addCustomer(customer);

        assertEquals(customer, hotelSystem.getCustomer("Tom123", "password"),
                "Should get the customer with username Tom123");
    }
}
