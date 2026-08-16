import java.util.Scanner;

public class SecurityPinAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String SECRET_PIN = "889900";
        int maxAttempts = 3;
        int attempts = 0;
        boolean loginSuccess = false;

        System.out.println("--- CỔNG XÁC THỰC AN TOÀN HỆ THỐNG ---");

        while (attempts < maxAttempts) {
            System.out.printf(
                    "[Lần %d/%d] Nhập mã PIN bảo mật: ",
                    attempts + 1,
                    maxAttempts
            );

            String pin = scanner.nextLine();

            if (pin.equals(SECRET_PIN)) {
                loginSuccess = true;

                System.out.println("+-------------------------------------------------------+");
                System.out.println("|  XÁC THỰC THÀNH CÔNG — CHÀO MỪNG QUẢN TRỊ VIÊN!     |");
                System.out.println("+-------------------------------------------------------+");

                break;
            }

            attempts++;

            int remainingAttempts = maxAttempts - attempts;

            if (remainingAttempts > 0) {
                System.out.printf(
                        " => Mật khẩu không chính xác! Bạn còn %d lần thử.%n",
                        remainingAttempts
                );
            }
        }

        if (!loginSuccess) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|  TÀI KHOẢN ĐÃ BỊ KHÓA DO NHẬP SAI QUÁ 3 LẦN!         |");
            System.out.println("+-------------------------------------------------------+");
        }

        scanner.close();
    }
}