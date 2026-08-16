import java.util.Scanner;

public class BridgeWeightLimitMonitoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int validCount = 0;
        int overloadCount = 0;

        System.out.println("--- TRẠM KIỂM SOÁT TẢI TRỌNG CẦU BÃI CHÁY ---");

        while (true) {
            int vehicleNumber = validCount + overloadCount + 1;

            System.out.printf(
                    "Nhập tải trọng xe số %d (Tấn, nhập -1 để kết thúc): ",
                    vehicleNumber
            );

            double weight = scanner.nextDouble();

            // Phải kiểm tra -1 trước
            if (weight == -1) {
                break;
            }

            // Các giá trị âm khác -1 là không hợp lệ
            if (weight < 0) {
                System.out.println(
                        " -> Lỗi: Tải trọng không hợp lệ. Vui lòng nhập lại!"
                );
                continue;
            }

            // Phân loại xe
            if (weight > 18.0) {
                System.out.println(
                        " -> VI PHẠM: Xe quá tải 18 Tấn -> Cấm qua cầu!"
                );
                overloadCount++;
            } else {
                System.out.println(
                        " -> Hợp lệ: Cho phép qua cầu."
                );
                validCount++;
            }
        }

        int totalVehicles = validCount + overloadCount;

        double overloadRate = 0;

        if (totalVehicles > 0) {
            overloadRate = (double) overloadCount / totalVehicles * 100;
        }

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|            BÁO CÁO TẢI TRỌNG CA TRỰC TRẠM CÂN       |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf(
                "| Tổng số xe được kiểm tra:    %-3d xe                  |%n",
                totalVehicles
        );

        System.out.printf(
                "| Số xe hợp lệ qua cầu:        %-3d xe                  |%n",
                validCount
        );

        System.out.printf(
                "| Số xe vi phạm quá tải:       %-3d xe (Tỷ lệ: %4.1f%%)   |%n",
                overloadCount,
                overloadRate
        );

        System.out.println("|-------------------------------------------------------|");

        if (overloadRate > 20) {
            System.out.println(
                    "| ĐÁNH GIÁ HẠ TẦNG:       NGUY CƠ QUÁ TẢI HẠ TẦNG CAO |"
            );
        } else {
            System.out.println(
                    "| ĐÁNH GIÁ HẠ TẦNG:       MỨC ĐỘ AN TOÀN               |"
            );
        }

        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}