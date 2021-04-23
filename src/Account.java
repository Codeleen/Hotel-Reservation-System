import java.time.LocalDate;

public class Account {
    private String username;
    private String password;
    private String name;
    private boolean isLoggedIn;

    public Account(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void authenticate() { }

    public String getName() {
        return name;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public void searchByDate(LocalDate startDate, LocalDate endDate) {}

    public void searchByPrice(double lowPrice, double highPrice) {}
}
