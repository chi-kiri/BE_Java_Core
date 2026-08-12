import java.util.Scanner;

public class LibraryCardRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG ĐĂNG KÝ THẺ THƯ VIỆN SỐ ---");

        System.out.print("Nhập mã thẻ độc giả: ");
        String cardId = sc.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String gender = sc.nextLine();

        System.out.print("Nhập tiền đặt cọc (VNĐ): ");
        double depositAmount = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập email liên hệ: ");
        String email = sc.nextLine();

        System.out.printf("""
                +-------------------------------------------------------------------+
                |               PHIẾU XÁC NHẬN ĐĂNG KÝ THẺ ĐỘC GIẢ                  |
                +-------------------------------------------------------------------+
                | Mã thẻ         : %-48s |
                | Họ và tên      : %-48s |
                | Tuổi           : %-48s |
                | Giới tính      : %-48s |
                | Tiền đặt cọc   : %,.2f VNĐ                                   |
                | Email liên hệ  : %-48s |
                +-------------------------------------------------------------------+
                | Trạng thái     : %-48s |
                +-------------------------------------------------------------------+
                """,
                cardId,
                fullName,
                age + " tuổi",
                gender,
                depositAmount,
                email,
                "THÀNH CÔNG - Hợp lệ kích hoạt thẻ thư viện"
        );
    }
}
