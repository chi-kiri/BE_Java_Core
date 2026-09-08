package Exercise06;

public class Vehicle {
    private String vehicleId;
    private String brand;
    private int year;

    public Vehicle(String vehicleId, String brand, int year) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo() {
        System.out.printf("[%s] Hãng: %s | Năm SX: %d%n",
                vehicleId, brand, year);
    }
}
