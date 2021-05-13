package model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * A class modeling a normal reservation at the hotel.
 */
public class NormalReservation implements Reservation {
    private String roomNumber;
    private DatePeriod datePeriod;

    /**
     * Constructor for a reservation.
     * @param roomNumber the room number the reservation is for.
     * @param datePeriod the date period for the reservation.
     */
    public NormalReservation(String roomNumber, DatePeriod datePeriod) {
        this.roomNumber = roomNumber;
        this.datePeriod = datePeriod;
    }

    /**
     * Getter for the room number.
     * @return the room number.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Getter for the period of time the reservation is for.
     * @return the date period.
     */
    public DatePeriod getDatePeriod() {
        return datePeriod;
    }

    /**
     * Getter for the price of a normal reservation.
     * @return the price.
     */
    public double getPrice() {
        LocalDate start = datePeriod.getStart();
        LocalDate end = datePeriod.getEnd();
        long daysInBetween = DAYS.between(start, end);
        return 100.0 * daysInBetween;
    }
}
