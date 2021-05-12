import model.Customer;
import model.DatePeriod;
import model.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the Customer model class
 */
public class CustomerTest {
    /**
     * Tests if cancelReservation() works by creating a reservation, then
     * cancelling it
     */
    @Test
    public void testCancelReservation() {
        Customer customer = new Customer("Tom", "Tom123", "password");
        LocalDate start = LocalDate.of(2021, 1, 1);
        LocalDate end = LocalDate.of(2021, 1, 15);
        DatePeriod datePeriod = new DatePeriod(start, end);
        customer.addReservation(new Reservation("1", datePeriod));

        customer.cancelReservation(0);
        assertTrue(customer.getReservations().isEmpty(),
                "Reservations should be empty after one addition and one removal");
    }
}
