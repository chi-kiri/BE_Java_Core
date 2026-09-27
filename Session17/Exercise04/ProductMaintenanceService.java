package Exercise04;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ProductMaintenanceService {
    private static final String DB_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();

        try (InputStream input = ProductMaintenanceService.class
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("Không tìm thấy file database.properties");
            }

            properties.load(input);

            DB_URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");

        } catch (IOException e) {
            throw new RuntimeException("Không thể đọc file database.properties", e);
        }
    }

    public int adjustPriceByCategory(String category,
                                     double percentageIncrease,
                                     int maxStockThreshold) {

        String sql = "UPDATE products " +
                "SET price = price * (1 + ? / 100.0) " +
                "WHERE category = ? AND stock_quantity <= ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, percentageIncrease);
            stmt.setString(2, category);
            stmt.setInt(3, maxStockThreshold);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.printf(
                        "[CẬP NHẬT GIÁ] Đã điều chỉnh tăng %.1f%% cho %d sản phẩm thuộc danh mục [%s].%n",
                        percentageIncrease,
                        rowsAffected,
                        category
                );
            } else {
                System.out.printf(
                        "[CẬP NHẬT GIÁ] Không có sản phẩm nào thuộc danh mục [%s] có tồn kho <= %d.%n",
                        category,
                        maxStockThreshold
                );
            }

            return rowsAffected;

        } catch (SQLException e) {
            System.out.printf(
                    "[LỖI UPDATE] SQLState: %s%nThông báo: %s%n",
                    e.getSQLState(),
                    e.getMessage()
            );
            return 0;
        }
    }

    public int removeDiscontinuedProducts() {
        String sql = "DELETE FROM products " +
                "WHERE status = 'DISCONTINUED' AND stock_quantity = 0";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.printf(
                        "[XÓA SẢN PHẨM] Đã dọn dẹp %d sản phẩm ngừng kinh doanh và hết hàng khỏi CSDL.%n",
                        rowsAffected
                );
            } else {
                System.out.println(
                        "[XÓA SẢN PHẨM] Không có sản phẩm ngừng kinh doanh và hết hàng cần xóa."
                );
            }

            return rowsAffected;

        } catch (SQLException e) {
            System.out.printf(
                    "[LỖI DELETE] SQLState: %s%nThông báo: %s%n",
                    e.getSQLState(),
                    e.getMessage()
            );
            return 0;
        }
    }
}