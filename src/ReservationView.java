import java.time.LocalDate;

public class ReservationView {
    public void printReservationDetails(int id, double price, LocalDate beginningDate, LocalDate endDate) {
        System.out.println("ID: ");
        System.out.println("Price: " + price);
        System.out.println("Start Date: " + beginningDate);
        System.out.println("End Date: " + endDate);
    }
}
