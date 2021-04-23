import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Account {
    private ArrayList<Reservation> reservations;

    public Customer(String name, String username, String password) {
        super(name, username, password);
    }

    public void createReservation(LocalDate startDate, LocalDate endDate) {}

    public void viewReservation(int reservationId) {}

    public void deleteReservation(int reservationId) {}
}
