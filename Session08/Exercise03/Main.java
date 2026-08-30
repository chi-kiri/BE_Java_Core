package Exercise03;

public class Main {
    public static void main(String[] args) {
        UserAccount account = new UserAccount("admin_rikkei", "Secret123");

        System.out.println("--- THỬ NGHIỆM ĐỔI MẬT KHẨU TÀI KHOẢN ---");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             NHẬT KÝ BẢO MẬT TÀI KHOẢN                |");
        System.out.println("+-------------------------------------------------------+");

        account.displayProfile();

        System.out.println("|-------------------------------------------------------|");

        account.changePassword("WrongPass", "NewPass999");
        account.changePassword("Secret123", "NewPass999");

        System.out.println("+-------------------------------------------------------+");
    }
}
