import java.util.Scanner;

public class LogisticsRevenueAccumulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalRevenue = 0;
        int validMonthsCount = 0;

        System.out.println(
                "--- THỐNG KÊ DOANH THU LOGISTICS 12 THÁNG (Đơn vị: Triệu VNĐ) ---"
        );

        for (int month = 1; month <= 12; month++) {
            System.out.printf("Nhập doanh thu Tháng %d: ", month);
            double revenue = scanner.nextDouble();

            if (revenue < 100) {
                System.out.printf(
                        " Nhắc nhở: Tháng %d có doanh thu < 100M -> Bỏ qua thống kê bình quân.%n",
                        month
                );

                continue;
            }

            totalRevenue += revenue;
            validMonthsCount++;
        }

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|           BÁO CÁO DOANH THU ĐẠT CHUẨN NĂM           |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf(
                "| Số tháng đạt tiêu chuẩn (>= 100M): %-10d tháng |%n",
                validMonthsCount
        );
        System.out.printf(
                "| Tổng doanh thu hợp lệ:             %,10.2f Triệu VNĐ |%n",
                totalRevenue
        );

        if (validMonthsCount == 0) {
            System.out.println(
                    "| Doanh thu bình quân tháng:         Không có dữ liệu   |"
            );
        } else {
            double averageRevenue = totalRevenue / validMonthsCount;

            System.out.printf(
                    "| Doanh thu bình quân tháng:         %,10.2f Triệu VNĐ |%n",
                    averageRevenue
            );
        }

        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}
