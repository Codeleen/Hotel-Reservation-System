import model.DatePeriod;
import model.Discount;
import model.NormalReservation;
import model.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the Discount class.
 */
public class DiscountTest {
    /**
     * Tests if calling getPrice() on a discounted reservation results in a lower price.
     */
    @Test
    public void testGetPrice() {
        LocalDate start = LocalDate.of(2021, 1, 14);
        LocalDate end = LocalDate.of(2021, 1, 15);
        DatePeriod datePeriod = new DatePeriod(start, end);
        Reservation reservation = new NormalReservation("1", datePeriod);
        reservation = new Discount(reservation);

        assertEquals(50.0, reservation.getPrice(), "Discount should reduce price to 50.00");
    }
}
