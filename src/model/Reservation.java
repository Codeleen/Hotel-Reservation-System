package model;

public class Reservation {
    private String roomNumber;
    private DatePeriod datePeriod;

    /**
     * Constructor for a reservation
     * @param roomNumber the room number the reservation is for
     * @param datePeriod the date period for the reservation
     */
    public Reservation(String roomNumber, DatePeriod datePeriod) {
        this.roomNumber = roomNumber;
        this.datePeriod = datePeriod;
    }

    /**
     * Getter for the date period
     * @return the date period for the reservation
     */
    public DatePeriod getDatePeriod() {
        return datePeriod;
    }
}
