package Exercise05;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[3];

        accounts[0] = new Account("Nguyễn Văn An", 5000000);
        accounts[1] = new Account("Trần Thị Hoa", 12000000);
        accounts[2] = new Account("Lê Văn Bình", 3500000);

        System.out.println("--- MỞ 3 TÀI KHOẢN NGÂN HÀNG MỚI ---");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|            DANH SÁCH TÀI KHOẢN MỞ MỚI (AUTO ID)     |");
        System.out.println("+-------------------------------------------------------+");

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayAccount();
        }

        System.out.println("+-------------------------------------------------------+");
    }
}
