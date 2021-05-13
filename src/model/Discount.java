package model;

/**
 * A class modeling a discount for a reservation.
 */
public class Discount implements Reservation {
    private Reservation reservation;

    /**
     * Constructor for Discount class.
     * @param reservation the reservation the discount is to be applied to.
     */
    public Discount(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Getter for the room number along with a discount indicator.
     * @return the room number.
     */
    @Override
    public String getRoomNumber() {
        return reservation.getRoomNumber() + " + Discount";
    }

    /**
     * Getter for the period of time the reservation is for.
     * @return the date period.
     */
    @Override
    public DatePeriod getDatePeriod() {
        return reservation.getDatePeriod();
    }

    /**
     * Getter for the price after the discount is applied.
     * @return the price of the discounted reservation.
     */
    @Override
    public double getPrice() {
        return reservation.getPrice() - 50.0;
    }
}
