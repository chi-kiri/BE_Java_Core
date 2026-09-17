package Exercise06;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC01");

        System.out.println("--- 3 KỊCH BẢN RÚT TIỀN RIKKEI BANK ---");
        System.out.println("Số dư đầu: 5000000 VNĐ");

        try {
            account.withdraw(-500000);
            System.out.println("[KB1]: RÚT TIỀN THÀNH CÔNG!");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[KB1]: LỖI: " + e.getMessage());
        }

        try {
            account.withdraw(10000000);
            System.out.println("[KB2]: RÚT TIỀN THÀNH CÔNG!");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[KB2]: LỖI: " + e.getMessage());
        }

        try {
            account.withdraw(2000000);
            System.out.println("[KB3]: -> RÚT TIỀN THÀNH CÔNG! Số dư mới: "
                    + String.format("%.2f", account.getBalance()) + " VNĐ");
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[KB3]: LỖI: " + e.getMessage());
        }
    }
}
