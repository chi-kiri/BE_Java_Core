package Exercise05;

public class SavingsAccount extends BankAccount {
    private int termMonths;

    public SavingsAccount(String accountId, double balance, int termMonths) {
        super(accountId, balance);
        this.termMonths = termMonths;
    }

    @Override
    public double calculateAnnualInterest() {
        return getBalance() * 0.068;
    }

    public int getTermMonths() {
        return termMonths;
    }
}
