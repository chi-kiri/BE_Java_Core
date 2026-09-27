package Exercise02;

public class Customer {
    private int customerId;
    private String fullName;
    private String email;
    private int loyaltyPoints;
    private boolean active;

    public Customer(int customerId, String fullName, String email, int loyaltyPoints, boolean active) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", active=" + active +
                '}';
    }
}