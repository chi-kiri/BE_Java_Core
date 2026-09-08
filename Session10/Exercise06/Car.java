package Exercise06;

public class Car extends Vehicle {
    private int numSeats;

    public Car(String vehicleId, String brand, int year, int numSeats) {
        super(vehicleId, brand, year);
        this.numSeats = numSeats;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("-> Đặc tả riêng: Số chỗ ngồi: " + numSeats + " chỗ");
    }
}
