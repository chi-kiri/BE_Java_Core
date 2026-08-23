import java.util.Arrays;
import java.util.Scanner;

public class CustomerPhonebookSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;

        do {
            System.out.print("--- CÔNG CỤ SẮP XẾP DANH BẠ VIP ---\nNhập số lượng SĐT (N): ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n < 3 || n > 20);

        String[] phoneList = new String[n];
        String regex = "^0[3|5|7|8|9]\\d{8}$";

        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Nhập SĐT #" + (i + 1) + ": ");
                phoneList[i] = scanner.nextLine().trim();

                if (!phoneList[i].matches(regex)) {
                    System.out.println("SĐT không hợp lệ, vui lòng nhập lại.");
                }
            } while (!phoneList[i].matches(regex));
        }

        String[] originalPhoneList = phoneList.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (phoneList[j].compareTo(phoneList[j + 1]) > 0) {
                    String temp = phoneList[j];
                    phoneList[j] = phoneList[j + 1];
                    phoneList[j + 1] = temp;
                }
            }
        }

        System.out.printf("""
                +-------------------------------------------------------+
                |             DANH BẠ KHÁCH HÀNG ĐÃ SẮP XẾP            |
                +-------------------------------------------------------+
                | Danh bạ ban đầu:
                | -> %s
                |-------------------------------------------------------|
                | Danh bạ theo thứ tự ABC (Tăng dần):
                | -> %s
                +-------------------------------------------------------+
                """,
                Arrays.toString(originalPhoneList),
                Arrays.toString(phoneList));

        scanner.close();
    }
}