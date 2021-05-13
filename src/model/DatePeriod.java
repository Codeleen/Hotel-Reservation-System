package model;

import java.time.LocalDate;

/**
 * A class modeling the period of time a reservation is for.
 */
public class DatePeriod {
    LocalDate start;
    LocalDate end;

    /**
     * Constructs a date period through which a reservation will last, checking if the
     * date period makes sense
     * @param start the beginning of the period
     * @param end the end of the period
     */
    public DatePeriod(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Starting date cannot be after the ending date.");
        }
        this.start = start;
        this.end = end;
    }

    /**
     * Getter for the date period start
     * @return the starting LocalDate
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * Getter for the date period end
     * @return the ending LocalDate
     */
    public LocalDate getEnd() {
        return end;
    }
}
