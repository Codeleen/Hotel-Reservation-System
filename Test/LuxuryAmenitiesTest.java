import model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the LuxuryAmenities class.
 */
public class LuxuryAmenitiesTest {
    /**
     * Tests if calling getPrice() on a reservation with luxury amenities results in a higher price.
     */
    @Test
    public void testGetPrice() {
        LocalDate start = LocalDate.of(2021, 1, 14);
        LocalDate end = LocalDate.of(2021, 1, 15);
        DatePeriod datePeriod = new DatePeriod(start, end);
        Reservation reservation = new NormalReservation("1", datePeriod);
        reservation = new LuxuryAmenities(reservation);

        assertEquals(150.0, reservation.getPrice(),
                "Discount should increase price to 150.00");
    }
}
