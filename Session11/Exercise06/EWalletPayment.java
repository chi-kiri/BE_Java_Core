package Exercise06;

public class EWalletPayment implements IPayment {
    @Override
    public double pay(double amount) {
        return amount * 0.98;
    }

    @Override
    public String getPaymentMethodName() {
        return "Ví điện tử - E-Wallet -2%";
    }
}
