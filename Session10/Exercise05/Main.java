package Exercise05;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("BA-001", 50000000);
        SavingsAccount savingsAccount = new SavingsAccount("SA-001", 50000000, 12);

        double normalInterest = bankAccount.calculateAnnualInterest();
        double savingsInterest = savingsAccount.calculateAnnualInterest();
        double difference = savingsInterest - normalInterest;

        System.out.printf("""
                --- SO SÁNH LÃI SUẤT 2 LOẠI TÀI KHOẢN ---

                +-------------------------------------------------------+
                |             BẢNG SO SÁNH TIỀN LÃI HÀNG NĂM           |
                +-------------------------------------------------------+
                | Số dư gốc giao dịch:      %,.2f VNĐ
                |-------------------------------------------------------|
                | [TK Thường - 1.2%%]:       %,.2f VNĐ / năm
                | [TK Tiết kiệm - 6.8%%]:    %,.2f VNĐ / năm
                | -> CHÊNH LỆCH LỢI NHUẬN:  +%,.2f VNĐ
                +-------------------------------------------------------+
                """,
                bankAccount.getBalance(),
                normalInterest,
                savingsInterest,
                difference);
    }
}
