package Exercise04;

public class VIPAccount extends Account {
    public VIPAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public boolean transfer(Account target, double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            target.deposit(amount);
            return true;
        }

        return false;
    }
}
