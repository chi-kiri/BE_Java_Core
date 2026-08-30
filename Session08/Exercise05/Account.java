package Exercise05;

public class Account {
    private static int autoId = 1001;
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String customerName, double balance) {
        this.accountNumber = "ACC-" + autoId++;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void displayAccount() {
        System.out.printf("""
                | Mã TK: %s | Chủ TK: %s
                | -> Số dư hiện tại: %,.0f VNĐ
                |-------------------------------------------------------|
                """,
                accountNumber,
                customerName,
                balance
        );
    }
}
