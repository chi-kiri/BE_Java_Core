import java.util.Scanner;

public class ProgressiveElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int LEVEL_1 = 50;
        final int LEVEL_2 = 100;
        final int LEVEL_3 = 200;
        final int LEVEL_4 = 300;
        final int LEVEL_5 = 400;

        final double PRICE_1 = 1800;
        final double PRICE_2 = 1860;
        final double PRICE_3 = 2160;
        final double PRICE_4 = 2720;
        final double PRICE_5 = 3050;

        final double VAT_RATE = 0.08;

        System.out.print("Nhập số điện tiêu thụ trong tháng (kWh): ");
        int kwh = Integer.parseInt(sc.nextLine());

        if (kwh < 0){
            System.out.println("Số điện tiêu thụ phải lớn hơn hoặc bằng 0.");
            sc.close();
        }

        double subtotal;
        if (kwh <= LEVEL_1){
            subtotal = kwh * PRICE_1;
        } else if (kwh <= LEVEL_2){
            subtotal = LEVEL_1*PRICE_1 + (kwh - LEVEL_1)*PRICE_2;
        } else if (kwh <= LEVEL_3){
            subtotal = LEVEL_1*PRICE_1 + (LEVEL_2 - LEVEL_1)*PRICE_2 + (kwh - LEVEL_2)*PRICE_3;
        } else if (kwh <= LEVEL_4){
            subtotal = LEVEL_1*PRICE_1 + (LEVEL_2 - LEVEL_1)*PRICE_2 + (LEVEL_3 - LEVEL_2)*PRICE_3 + (kwh - LEVEL_3)*PRICE_4;
        } else {
            subtotal = LEVEL_1*PRICE_1 + (LEVEL_2 - LEVEL_1)*PRICE_2 + (LEVEL_3 - LEVEL_2)*PRICE_3 + (LEVEL_4 - LEVEL_3)*PRICE_4 + (kwh - LEVEL_4)*PRICE_5;
        }

        double vatAmount = subtotal * VAT_RATE;
        double totalAmount = subtotal + vatAmount;

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             CHI TIẾT HÓA ĐƠN TIỀN ĐIỆN               |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Lượng điện tiêu thụ:         %-6d kWh                |%n", kwh);
        System.out.printf("| Tiền điện chưa thuế:     %,14.2f VNĐ           |%n", subtotal);
        System.out.printf("| Thuế VAT (8%%):          %,14.2f VNĐ           |%n", vatAmount);
        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| TỔNG CỘNG THANH TOÁN:    %,14.2f VNĐ           |%n", totalAmount);
        System.out.println("+-------------------------------------------------------+");
    }
}
