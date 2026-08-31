package Exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                --- GIAO DỊCH THẺ TÍN DỤNG RIKKEI BANK ---
                Nhập tên chủ thẻ: """);

        String holderName = scanner.nextLine();

        CreditAccount account = new CreditAccount(holderName);

        System.out.printf("Thẻ: %s, Chủ thẻ: \"%s\"%n",
                account.getAccountId(),
                account.getHolderName());

        System.out.print("Nhập số tiền giao dịch 1: ");
        double amount1 = Double.parseDouble(scanner.nextLine());

        account.spend(amount1);

        System.out.print("Nhập số tiền giao dịch 2: ");
        double amount2 = Double.parseDouble(scanner.nextLine());

        account.spend(amount2);

        account.displayAccount();

        scanner.close();
    }
}
