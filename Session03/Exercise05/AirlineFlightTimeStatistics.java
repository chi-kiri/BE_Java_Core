import java.util.Scanner;

public class AirlineFlightTimeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalFlightHours = 0;
        int validFlights = 0;

        System.out.println("--- THỐNG KÊ HOẠT ĐỘNG BAY RIKKEI AIRLINES ---");

        System.out.print("Nhập số chuyến bay cần thống kê (N): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Nhập giờ bay của Chuyến số %d: ", i);
            double flightHour = scanner.nextDouble();

            if (flightHour <= 0) {
                if (flightHour == 0) {
                    System.out.printf(
                            " -> Cảnh báo: Chuyến bay số %d bị hủy (0 giờ) -> Bỏ qua thống kê.%n",
                            i
                    );
                } else {
                    System.out.printf(
                            " -> Cảnh báo: Chuyến bay số %d lỗi dữ liệu -> Bỏ qua thống kê.%n",
                            i
                    );
                }

                continue;
            }

            totalFlightHours += flightHour;
            validFlights++;
        }

        double averageFlightHours = 0;

        if (validFlights > 0) {
            averageFlightHours = totalFlightHours / validFlights;
        }

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             BÁO CÁO THỐNG KÊ HOẠT ĐỘNG BAY          |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Tổng chuyến bay thống kê:    %-3d chuyến              |%n", n);
        System.out.printf("| Số chuyến bay thành công:    %-3d chuyến              |%n", validFlights);
        System.out.printf("| Tổng giờ bay tích lũy:       %-6.2f giờ               |%n", totalFlightHours);

        if (validFlights == 0) {
            System.out.println("| Thời gian bay bình quân:     Không có dữ liệu         |");
        } else {
            System.out.printf(
                    "| Thời gian bay bình quân:     %-6.2f giờ/chuyến        |%n",
                    averageFlightHours
            );
        }

        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}
