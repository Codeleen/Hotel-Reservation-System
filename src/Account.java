import java.util.ArrayList;

public class Account {
    private String name;
    private String username;
    private String password;
    private boolean isLoggedIn;
    private ArrayList<Reservation> reservations;

    public Account(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

//    public boolean authenticate(String username, String password) {}

    public String getName() {
        return name;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

//    public ArrayList<Reservation> searchByDate(LocalDate startDate, LocalDate endDate) {}

//    public ArrayList<Reservation> searchByPrice(double lowPrice, double highPrice) {}

//    public ArrayList<Reservation> searchById(int reservationId) {}
}
