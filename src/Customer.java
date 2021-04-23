import java.time.LocalDate;

public class Customer extends Account {
    private int id;

    public Customer(String name, String username, String password) {
        super(name, username, password);
    }

    public int getId() {
        return id;
    }

    public void createReservation(LocalDate startDate, LocalDate endDate) {

    }

    public void viewReservation(int reservationId) {

    }

    public void deleteReservation(int reservationId) {

    }
}
