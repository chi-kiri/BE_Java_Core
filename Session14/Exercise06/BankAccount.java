package Exercise06;

public class BankAccount {
    private String accId;
    private double balance = 5000000.0;

    public BankAccount(String accId) {
        this.accId = accId;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0!");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Số dư không đủ! (Hiện có: " + String.format("%.2f", balance)
                            + ", Yêu cầu: " + String.format("%.2f", amount) + ")"
            );
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
