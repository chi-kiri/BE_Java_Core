package Exercise06;

import java.util.Comparator;
import java.util.List;

public class OrderAnalytics {
    public double calculateTotalRevenue(List<Order> list) {
        return list.stream()
                .filter(order -> order.getStatus().equals("SUCCESS"))
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

    public double calculateAverageValue(List<Order> list) {
        return list.stream()
                .filter(order -> order.getStatus().equals("SUCCESS"))
                .mapToDouble(Order::getTotalAmount)
                .average()
                .orElse(0.0);
    }

    public Order findMaxOrder(List<Order> list) {
        return list.stream()
                .filter(order -> order.getStatus().equals("SUCCESS"))
                .max(Comparator.comparingDouble(Order::getTotalAmount))
                .orElse(null);
    }
}