import java.util.Scanner;

public class ColdStorageTemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tempC = 0;

        System.out.println("--- CÔNG CỤ QUY ĐỔI NHIỆT ĐỘ KHO LẠNH VACCINE ---");
        System.out.println("1. Nhập độ C (Celsius) | 2. Nhập độ F (Fahrenheit) | 3. Nhập độ K (Kelvin)");

        System.out.print("Chọn đơn vị gốc (1-3): ");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập giá trị nhiệt độ: ");
        double temperature = Double.parseDouble(scanner.nextLine());

        // Chuyển nhiệt độ đầu vào về Celsius
        switch (choice) {
            case 1:
                tempC = temperature;
                break;

            case 2:
                tempC = (temperature - 32.0) * 5.0 / 9.0;
                break;

            case 3:
                tempC = temperature - 273.15;
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ!");
                scanner.close();
                return;
        }

        // Từ Celsius chuyển sang Fahrenheit và Kelvin
        double tempF = tempC * 9.0 / 5.0 + 32.0;
        double tempK = tempC + 273.15;

        String status;

        if (tempC >= -2.0 && tempC <= 8.0) {
            status = "AN TOÀN - ĐẠT CHUẨN BẢO QUẢN";
        } else {
            status = "CẢNH BÁO NGUY HIỂM - VI PHẠM DẢI NHIỆT ĐỘ VACCINE";
        }

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|           BẢNG QUY ĐỔI NHIỆT ĐỘ KHO BẢO QUẢN        |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Nhiệt độ Celsius (C):        %8.2f °C               |%n", tempC);
        System.out.printf("| Nhiệt độ Fahrenheit (F):     %8.2f °F               |%n", tempF);
        System.out.printf("| Nhiệt độ Kelvin (K):         %8.2f K                |%n", tempK);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| ĐÁNH GIÁ AN TOÀN:     %-34s |%n", status);
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}
