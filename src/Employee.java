public class Employee extends Account {
    public Employee(String name, String username, String password) {
        super(name, username, password);
    }

    public void loginAsCustomer(String customerUsername) {}

    public void createEmployee(String name, String username, String password) {}

    public void deleteEmployee(String employeeUsername) {}

    public void searchById(int reservationId) {}
}
