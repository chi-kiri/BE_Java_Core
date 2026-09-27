package Exercise02;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerQueryDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream input = CustomerQueryDemo.class
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                System.out.println("Không tìm thấy file database.properties");
                return;
            }

            properties.load(input);

        } catch (IOException e) {
            System.out.println("Lỗi đọc file cấu hình: " + e.getMessage());
            return;
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        String sql = "SELECT * FROM customers " +
                "WHERE loyalty_points >= 500 " +
                "ORDER BY loyalty_points DESC";

        List<Customer> customers = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getInt("loyalty_points"),
                        rs.getBoolean("is_active")
                );

                customers.add(customer);
            }

        } catch (SQLException e) {
            System.out.printf(
                    "Lỗi truy vấn Database!%nSQLState: %s%nThông báo: %s%n",
                    e.getSQLState(),
                    e.getMessage()
            );
            return;
        }

        System.out.printf(
                "=======================================================================================%n" +
                        "       DANH SÁCH KHÁCH HÀNG VIP (ĐIỂM TÍCH LŨY >= 500) - RIKKEI STORE%n" +
                        "=======================================================================================%n" +
                        "%-7s | %-24s | %-30s | %-10s | %-12s%n" +
                        "---------------------------------------------------------------------------------------%n",
                "ID", "HỌ VÀ TÊN", "EMAIL", "ĐIỂM", "TRẠNG THÁI"
        );

        for (Customer customer : customers) {
            String status;

            if (customer.isActive()) {
                status = "Hoạt động";
            } else {
                status = "Không hoạt động";
            }

            System.out.printf(
                    "%-7d | %-24s | %-30s | %-10d | %-12s%n",
                    customer.getCustomerId(),
                    customer.getFullName(),
                    customer.getEmail(),
                    customer.getLoyaltyPoints(),
                    status
            );
        }

        System.out.printf(
                "=======================================================================================%n" +
                        "Tổng số khách hàng VIP trong danh sách: %d%n" +
                        "=======================================================================================%n",
                customers.size()
        );
    }
}