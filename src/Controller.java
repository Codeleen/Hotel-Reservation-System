import java.time.LocalDate;

public class Controller {
    private Reservation reservationModel;
    private ReservationView reservationView;

    public Controller(Reservation reservationModel, ReservationView reservationView) {
        this.reservationModel = reservationModel;
        this.reservationView = reservationView;
    }

    public void login() {}

    public void setReservationId(int id) {
        reservationModel.setId(id);
    }

    public int getReservationId() {
        return reservationModel.getId();
    }

    public void setReservationPrice(double price) {
        reservationModel.setPrice(price);
    }

    public double getReservationPrice() {
        return reservationModel.getPrice();
    }

    public void setReservationStartDate(LocalDate startDate) {
        reservationModel.setStartDate(startDate);
    }

    public LocalDate getReservationStartDate() {
        return reservationModel.getStartDate();
    }

    public void setReservationModelEndDate(LocalDate endDate) {
        reservationModel.setEndDate(endDate);
    }

    public LocalDate getReservationEndDate() {
        return reservationModel.getEndDate();
    }

    public void updateView() {
        reservationView.printReservationDetails(reservationModel.getId(), reservationModel.getPrice(),
                reservationModel.getStartDate(), reservationModel.getEndDate());
    }
}
