package Exercise06;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR-01", "Toyota", 2024, 5);
        Truck truck = new Truck("TRK-01", "Hyundai", 2023, 15.5);

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             HỒ SƠ PHƯƠNG TIỆN VẬN TẢI RIKKEI        |");
        System.out.println("+-------------------------------------------------------+");

        car.displayInfo();

        System.out.println("|-------------------------------------------------------|");

        truck.displayInfo();

        System.out.println("+-------------------------------------------------------+");
    }
}
