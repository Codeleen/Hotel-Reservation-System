import java.time.LocalDate;

public class Reservation {
    private int id;
    private double price;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(int id, double price, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculatePrice(LocalDate startDate, LocalDate endDate) {
        return 0.0;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate beginningDate) {
        this.startDate = beginningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
