package Exercise06;

public class Main {
    public static void main(String[] args) {
        double amount = 1000000;

        IPayment[] methods = {
                new CashPayment(),
                new CreditCardPayment(),
                new EWalletPayment()
        };

        StringBuilder result = new StringBuilder();

        int index = 1;

        for (IPayment p : methods) {
            result.append(String.format(
                    "| %d. [%-28s]: %,.2f VNĐ%n",
                    index,
                    p.getPaymentMethodName(),
                    p.pay(amount)
            ));
            index++;
        }

        System.out.printf("""
                --- THANH TOÁN ĐƠN HÀNG 1,000,000 VNĐ QUA 3 CỔNG ---

                +--------------------------------------------------------------+
                |             BẢNG SO SÁNH PHÍ CỔNG THANH TOÁN                 |
                +--------------------------------------------------------------+
                | Đơn hàng gốc cần thanh toán: %,.2f VNĐ
                |--------------------------------------------------------------|
                %s+--------------------------------------------------------------+
                """,
                amount,
                result);
    }
}
