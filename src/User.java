public class User {

    private String userId;
    private String username;
    private String password;
    private float balance;
    private boolean isOnline;

    // Constructeur
    public User(String userId, String username, String password, float balance, boolean isOnline) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.isOnline = isOnline;
    }

    // Getters et setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }
}
