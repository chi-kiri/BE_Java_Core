package Exercise06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("ORD01", "SUCCESS", 2000000));
        orders.add(new Order("ORD02", "SUCCESS", 5000000));
        orders.add(new Order("ORD03", "CANCELLED", 8000000));
        orders.add(new Order("ORD04", "SUCCESS", 3000000));
        orders.add(new Order("ORD05", "CANCELLED", 4000000));

        OrderAnalytics analytics = new OrderAnalytics();

        double totalRevenue = analytics.calculateTotalRevenue(orders);
        double averageValue = analytics.calculateAverageValue(orders);
        Order maxOrder = analytics.findMaxOrder(orders);

        System.out.printf("""
                +-------------------------------------------------------+
                |             BÁO CÁO PHÂN TÍCH DOANH THU STREAM       |
                +-------------------------------------------------------+
                | 1. Tổng doanh thu hợp lệ  : %,.2f VNĐ
                | 2. Giá trị đơn trung bình : %,.2f VNĐ
                | 3. Đơn hàng lớn nhất      : %s (%,.2f VNĐ)
                +-------------------------------------------------------+
                """,
                totalRevenue,
                averageValue,
                maxOrder.getId(),
                maxOrder.getTotalAmount());
    }
}