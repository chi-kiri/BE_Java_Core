package Exercise06;

public class CashPayment implements IPayment {
    @Override
    public double pay(double amount) {
        return amount;
    }

    @Override
    public String getPaymentMethodName() {
        return "Tiền mặt - Cash";
    }
}