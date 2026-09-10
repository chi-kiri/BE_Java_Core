package Exercise04;

public class StandardAccount extends Account {
    public StandardAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean transfer(Account target, double amount) {
        double fee = 5000;

        if (getBalance() >= amount + fee) {
            setBalance(getBalance() - amount - fee);
            target.deposit(amount);
            return true;
        }

        return false;
    }
}
