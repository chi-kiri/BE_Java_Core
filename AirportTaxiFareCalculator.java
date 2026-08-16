import java.util.Scanner;

public class AirportTaxiFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double FIRST_KM_FARE = 20000;
        final double FROM_2_TO_20_FARE = 15000;
        final double FROM_21_FARE = 12000;
        final double NIGHT_SURCHARGE_RATE = 0.20;

        System.out.println("--- HỆ THỐNG TÍNH CƯỚC RIKKEI AIRPORT TAXI ---");

        System.out.print("Nhập quãng đường di chuyển (km): ");
        double distance = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập giờ xuất phát (0 - 23h): ");
        int hour = Integer.parseInt(scanner.nextLine());

        // Tính cước theo quãng đường
        double baseFare;

        if (distance <= 1) {
            baseFare = FIRST_KM_FARE;
        } else if (distance <= 20) {
            baseFare = FIRST_KM_FARE
                    + (distance - 1) * FROM_2_TO_20_FARE;
        } else {
            baseFare = FIRST_KM_FARE
                    + 19 * FROM_2_TO_20_FARE
                    + (distance - 20) * FROM_21_FARE;
        }

        // Kiểm tra khung giờ đêm
        boolean isNight = hour >= 22 || hour <= 5;

        double nightSurcharge;

        if (isNight) {
            nightSurcharge = baseFare * NIGHT_SURCHARGE_RATE;
        } else {
            nightSurcharge = 0;
        }

        double totalFare = baseFare + nightSurcharge;

        // In hóa đơn
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             HÓA ĐƠN CƯỚC PHÍ TAXI SÂN BAY            |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Quãng đường di chuyển:       %-8.2f km               |%n", distance);

        if (isNight) {
            System.out.printf("| Giờ khởi hành:               %02d:00 (Khung giờ đêm)    |%n", hour);
        } else {
            System.out.printf("| Giờ khởi hành:               %02d:00                    |%n", hour);
        }

        System.out.printf("| Cước phí theo quãng đường:   %,12.2f VNĐ           |%n", baseFare);
        System.out.printf("| Phụ thu chạy đêm (20%%):      %,12.2f VNĐ           |%n", nightSurcharge);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| TỔNG CƯỚC THANH TOÁN:        %,12.2f VNĐ           |%n", totalFare);
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}