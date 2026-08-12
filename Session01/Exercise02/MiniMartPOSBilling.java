import java.util.Scanner;

public class MiniMartPOSBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG THU NGÂN MINIMART POS ---");

        System.out.print("Nhập tên mặt hàng 1: ");
        String itemName1 = sc.nextLine();

        System.out.print("Nhập giá mặt hàng 1 (VNĐ): ");
        double itemPrice1 = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập tên mặt hàng 2: ");
        String itemName2 = sc.nextLine();

        System.out.print("Nhập giá mặt hàng 2 (VNĐ): ");
        double itemPrice2 = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập tên mặt hàng 3: ");
        String itemName3 = sc.nextLine();

        System.out.print("Nhập giá mặt hàng 3 (VNĐ): ");
        double itemPrice3 = Double.parseDouble(sc.nextLine());

        final double VAT_RATE = 0.08;
        final double DISCOUNT_RATE = 0.05;

        double subTotal = 0;
        subTotal += itemPrice1;
        subTotal += itemPrice2;
        subTotal += itemPrice3;

        double vatAmount = subTotal * VAT_RATE;
        double discountAmount = subTotal * DISCOUNT_RATE;
        double totalAmount = subTotal + vatAmount - discountAmount;

        System.out.printf("""
                =====================================================================
                              HÓA ĐƠN BÁN LẺ MINIMART POS
                =====================================================================
                STT | Tên mặt hàng                         | Thành tiền (VNĐ)
                ---------------------------------------------------------------------
                 1  | %-36s | %,15.2f
                 2  | %-36s | %,15.2f
                 3  | %-36s | %,15.2f
                ---------------------------------------------------------------------
                TỔNG TIỀN HÀNG (SUBTOTAL)                  : %,15.2f
                THUẾ GTGT (VAT 8%%)                        : %,15.2f
                CHIẾT KHẤU THÀNH VIÊN (5%%)                : %,15.2f
                =====================================================================
                TỔNG TIỀN THANH TOÁN (TOTAL)               : %,15.2f
                =====================================================================
                           Cảm ơn Quý khách & Hẹn gặp lại tại MiniMart!
                =====================================================================
                """,
                itemName1,
                itemPrice1,
                itemName2,
                itemPrice2,
                itemName3,
                itemPrice3,
                subTotal,
                vatAmount,
                discountAmount,
                totalAmount
        );
    }
}
