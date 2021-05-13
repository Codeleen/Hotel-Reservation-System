package model;

/**
 * An interface allowing for the ArrayList of reservations to contain
 * any type of reservation.
 */
public interface Reservation {
    String getRoomNumber();
    DatePeriod getDatePeriod();
    double getPrice();
}
