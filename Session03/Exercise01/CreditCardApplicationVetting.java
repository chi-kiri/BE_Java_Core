import java.util.Scanner;

public class CreditCardApplicationVetting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isApproved = false;
        double creditLimit = 0;
        String rejectReason = "";

        System.out.println("--- HỆ THỐNG THẨM ĐỊNH HỒ SƠ TÍN DỤNG RIKKEI BANK ---");

        System.out.print("Nhập họ tên người nộp đơn: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập độ tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập thu nhập ròng tháng (VNĐ): ");
        double monthlyIncome = Double.parseDouble(scanner.nextLine());

        System.out.print("Khách hàng có nợ xấu không? (true/false): ");
        boolean hasBadDebt = Boolean.parseBoolean(scanner.nextLine());

        // Thẩm định hồ sơ
        if (age < 20 || age > 60) {
            rejectReason = "Ngoài độ tuổi quy định";
        } else if (hasBadDebt) {
            rejectReason = "Lịch sử tín dụng có nợ xấu";
        } else if (monthlyIncome < 10000000.0) {
            rejectReason = "Thu nhập dưới mức tối thiểu 10 triệu VNĐ";
        } else {
            isApproved = true;
            creditLimit = monthlyIncome * 3;
        }

        String badDebtStatus;

        if (hasBadDebt) {
            badDebtStatus = "Có";
        } else {
            badDebtStatus = "Không có";
        }

        // In kết quả
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|              KẾT QUẢ THẨM ĐỊNH TÍN DỤNG             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Người nộp đơn:               %-23s |%n", fullName);
        System.out.printf("| Tuổi:                        %-3d tuổi               |%n", age);
        System.out.printf("| Thu nhập tháng:              %,15.2f VNĐ       |%n", monthlyIncome);
        System.out.printf("| Trạng thái nợ xấu:           %-23s |%n", badDebtStatus);
        System.out.println("|-------------------------------------------------------|");

        if (isApproved) {
            System.out.println("| KẾT QUẢ PHÊ DUYỆT:           ĐẠT YÊU CẦU             |");
            System.out.printf(
                    "| HẠN MỨC THẺ ĐƯỢC CẤP:        %,15.2f VNĐ       |%n",
                    creditLimit
            );
        } else {
            System.out.println("| KẾT QUẢ PHÊ DUYỆT:           KHÔNG ĐẠT               |");
            System.out.printf("| Lý do:                       %-23s |%n", rejectReason);
        }

        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}
