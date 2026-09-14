package Exercise04;

public interface ISecureTransaction {
    boolean authenticate(String pinCode);

    boolean executeTransaction(double amount);
}