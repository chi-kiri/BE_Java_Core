import java.util.Scanner;

public class HotelBookingFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã đặt phòng: ");
        String bookingId = sc.nextLine();

        System.out.print("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();

        System.out.print("Nhập đơn giá phòng 1 đêm (VNĐ): ");
        double roomRate = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số đêm lưu trú: ");
        int nights = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập phí dịch vụ spa/ẩm thực: ");
        double serviceCost = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập trạng thái thẻ VIP (true/false): ");
        boolean isVip = Boolean.parseBoolean(sc.nextLine());

        final double VAT_RATE = 0.10;
        final double SERVICE_RATE = 0.05;

        double roomCost = roomRate * nights;
        double subTotal = roomCost;
        subTotal += serviceCost;
        double vatAmount = subTotal * VAT_RATE;
        double serviceFee = subTotal * SERVICE_RATE;
        double totalAmount = subTotal + vatAmount + serviceFee;
        boolean isEligibleForGift = isVip && nights >= 3;

        System.out.printf("""
        =====================================================================
                     HÓA ĐƠN LƯU TRÚ RIKKEI LUXURY HOTEL
        =====================================================================
        Mã đặt phòng             : %s
        Khách hàng               : %s | Thẻ VIP: %b
        ---------------------------------------------------------------------
        CHI TIẾT CHI PHÍ (COST BREAKDOWN):
        - Tiền phòng (%d đêm)                     : %,20.2f VNĐ
        - Phí dịch vụ spa/ẩm thực                : %,20.2f VNĐ
        ---------------------------------------------------------------------
        TỔNG TRƯỚC THUẾ (SUBTOTAL)               : %,20.2f VNĐ
        - Thuế GTGT (VAT 10%%)                    : %,20.2f VNĐ
        - Phí phục vụ (Service Fee 5%%)           : %,20.2f VNĐ
        =====================================================================
        TỔNG THANH TOÁN (TOTAL AMOUNT)           : %,20.2f VNĐ
        =====================================================================
        QUYỀN LỢI QUÀ TẶNG ĐẶC BIỆT (VIP & >=3 đêm): %b
        =====================================================================
        """,
                bookingId,
                customerName,
                isVip,
                nights,
                roomCost,
                serviceCost,
                subTotal,
                vatAmount,
                serviceFee,
                totalAmount,
                isEligibleForGift
        );
    }
}
