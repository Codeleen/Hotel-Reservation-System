import model.DatePeriod;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the DatePeriod class.
 */
public class DatePeriodTest {
    /**
     * Tests if the DatePeriod constructor throws an exception when calling it with a startDate that is
     * after the endDate.
     */
    @Test
    public void testDatePeriodConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new DatePeriod(LocalDate.of(2021, 12, 30),
                    LocalDate.of(2021, 1, 1))
        );
    }
}
