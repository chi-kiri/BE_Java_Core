package Exercise06;

public class CreditCardPayment implements IPayment {
    @Override
    public double pay(double amount) {
        return amount * 1.015;
    }

    @Override
    public String getPaymentMethodName() {
        return "Thẻ tín dụng - Card 1.5%";
    }
}
