public class EcommerceOrderLogParsingTool {
    public static void main(String[] args) {
        String[] logs = {
                "ORD-001|2026-08-03|2500000.0|SUCCESS",
                "ORD-002|2026-08-03|1200000.0|CANCELLED",
                "ORD-003|2026-08-03|4800000.0|SUCCESS",
                "ORD-004|2026-08-03|850000.0|SUCCESS",
                "ORD-005|2026-08-03|3200000.0|FAILED"
        };

        double totalRevenue = 0;
        int successCount = 0;
        String maxOrderCode = "";
        double maxOrderValue = 0;

        for (String log : logs) {
            String[] parts = log.split("\\|");

            if (parts[3].equals("SUCCESS")) {
                try {
                    double orderValue = Double.parseDouble(parts[2]);

                    totalRevenue += orderValue;
                    successCount++;

                    if (orderValue > maxOrderValue) {
                        maxOrderValue = orderValue;
                        maxOrderCode = parts[0];
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu số tiền không hợp lệ: " + parts[2]);
                }
            }
        }

        System.out.printf("""
                --- MODULE PHÂN TÍCH GIAO DỊCH E-COMMERCE ---
                Đang xử lý %d dòng nhật ký giao dịch...

                +-------------------------------------------------------+
                |          BÁO CÁO DOANH THU ĐƠN HÀNG THÀNH CÔNG       |
                +-------------------------------------------------------+
                | Tổng số giao dịch xử lý:        %d đơn hàng
                | Giao dịch thành công (SUCCESS): %d đơn hàng
                |-------------------------------------------------------|
                | TỔNG DOANH THU HỢP LỆ:          %,.2f VNĐ
                | ĐƠN HÀNG LỚN NHẤT:              %s (%,.0f VNĐ)
                +-------------------------------------------------------+
                """,
                logs.length,
                logs.length,
                successCount,
                totalRevenue,
                maxOrderCode,
                maxOrderValue);
    }
}