package Exercise06;

public class Order {
    private String id;
    private String status;
    private double totalAmount;

    public Order(String id, String status, double totalAmount) {
        this.id = id;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}