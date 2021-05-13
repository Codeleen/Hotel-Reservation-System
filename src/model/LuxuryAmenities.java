package model;

/**
 * A class modeling luxury amenities for a reservation.
 */
public class LuxuryAmenities implements Reservation {
    private Reservation reservation;

    /**
     * Constructor for LuxuryAmenities.
     * @param reservation the reservation the amenities are to be applied to.
     */
    public LuxuryAmenities(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Getter for the room number along with a luxury amenities indicator.
     * @return the room number.
     */
    @Override
    public String getRoomNumber() {
        return reservation.getRoomNumber() + " + Luxury Amenities";
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
     * Getter for the price of the reservation with the luxury amenities.
     * @return the price of a reservation with the amenities.
     */
    @Override
    public double getPrice() {
        return reservation.getPrice() * 1.5;
    }
}
