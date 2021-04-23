import java.time.LocalDate;

public class Customer extends Account {
    public Customer(String name, String username, String password) {
        super(name, username, password);
    }

    public void createReservation(LocalDate startDate, LocalDate endDate) {}

//    public Reservation viewReservation(int reservationId) {}

    public void deleteReservation(int reservationId) {}
}
