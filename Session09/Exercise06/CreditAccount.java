package Exercise06;

public class CreditAccount {
    public static final double CREDIT_LIMIT = 50000000.0;
    private static int autoId = 1001;

    private String accountId;
    private String holderName;
    private double currentDebt = 0;

    public CreditAccount(String holderName) {
        this.accountId = "CREDIT-" + autoId++;
        this.holderName = holderName;
    }

    public boolean spend(double amount) {
        if (amount > 0 && currentDebt + amount <= CREDIT_LIMIT) {
            currentDebt += amount;

            System.out.printf("""
                    [Chi tiêu] %,.0f VNĐ => Thành công
                    -> Dư nợ hiện tại: %,.0f VNĐ
                    """, amount, currentDebt);

            return true;
        }

        System.out.printf("""
                [Chi tiêu] %,.0f VNĐ => TỪ CHỐI! VƯỢT HẠN MỨC
                -> Hạn mức khả dụng chỉ còn: %,.0f VNĐ
                """, amount, CREDIT_LIMIT - currentDebt);

        return false;
    }

    public void payDebt(double amount) {
        if (amount > 0) {
            if (amount >= currentDebt) {
                currentDebt = 0;
            } else {
                currentDebt -= amount;
            }
        }
    }

    public void displayAccount() {
        System.out.printf("""
                +-------------------------------------------------------+
                |             SAO KÊ THẺ TÍN DỤNG RIKKEI BANK          |
                +-------------------------------------------------------+
                | Mã thẻ: %-14s | Chủ thẻ: %-20s
                | Hạn mức tín dụng:      %,.0f VNĐ
                | Dư nợ hiện tại:        %,.0f VNĐ
                | Hạn mức còn lại:       %,.0f VNĐ
                +-------------------------------------------------------+
                """,
                accountId,
                holderName,
                CREDIT_LIMIT,
                currentDebt,
                CREDIT_LIMIT - currentDebt);
    }

    public String getAccountId() {
        return accountId;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }
}