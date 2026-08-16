import java.util.Scanner;

public class ServerPrimeTokenAuditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ID bắt đầu (startId): ");
        int startId = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập ID kết thúc (endId): ");
        int endId = Integer.parseInt(sc.nextLine());

        int count = 0;
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|         DANH SÁCH MÁY CHỦ ĐẠT MÃ KHÓA VÀNG          |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("|Dải quét ID: %d đến %d%n|", startId, endId);
        System.out.print("| Các ID Nguyên tố (Prime): ");
        for (int i = startId; i <= endId; i++) {
            boolean isPrime = true;

            if (i <= 1){
                isPrime = false;
            }
            for(int j = 2; i*j <= i; j++){
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
                count ++;
            }
        }

        System.out.println();
        System.out.printf("| Tổng số máy chủ đạt chuẩn: %d máy chủ%n", count);
        System.out.println("+-------------------------------------------------------+");
    }
}
