package Exercise04;

public class OnlineBankingTransaction implements ISecureTransaction {
    private String validPin = "1234";
    private boolean isAuthenticated = false;
    private double balance = 10000000.0;

    @Override
    public boolean authenticate(String pinCode) {
        isAuthenticated = validPin.equals(pinCode);
        return isAuthenticated;
    }

    @Override
    public boolean executeTransaction(double amount) {
        if (!isAuthenticated) {
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public double getBalance() {
        return balance;
    }
}
