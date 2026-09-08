package Exercise06;

public class Truck extends Vehicle {
    private double payloadTons;

    public Truck(String vehicleId, String brand, int year, double payloadTons) {
        super(vehicleId, brand, year);
        this.payloadTons = payloadTons;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("-> Đặc tả riêng: Tải trọng: " + payloadTons + " tấn");
    }
}