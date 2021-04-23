public class Account {
    private String username;
    private String password;
    private String name;

    public Account(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void authenticate() { }

    public String getName() {
        return name;
    }
}
