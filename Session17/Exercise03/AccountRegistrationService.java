package Exercise03;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AccountRegistrationService {
    private static final String DB_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();

        try (InputStream input = AccountRegistrationService.class
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

    public boolean registerAccount(String accountNumber,
                                   String holderName,
                                   double initialBalance,
                                   String accountType) {

        String checkSql = "SELECT 1 FROM bank_accounts WHERE account_number = ?";
        String insertSql = "INSERT INTO bank_accounts " +
                "(account_number, account_holder, balance, account_type) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setString(1, accountNumber);

            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf(
                            "[TỪ CHỐI] Số tài khoản %s đã tồn tại trong hệ thống!%n",
                            accountNumber
                    );
                    return false;
                }
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, accountNumber);
                insertStmt.setString(2, holderName);
                insertStmt.setDouble(3, initialBalance);
                insertStmt.setString(4, accountType);

                int rowsAffected = insertStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.printf("""
                            [THÀNH CÔNG] Đăng ký mở tài khoản ngân hàng thành công!
                              - Số tài khoản : %s
                              - Chủ tài khoản: %s
                              - Số dư đầu kỳ : %,.2f VND
                              - Loại hình     : %s
                            """,
                            accountNumber,
                            holderName,
                            initialBalance,
                            accountType
                    );
                    return true;
                } else {
                    System.out.println("[THẤT BẠI] Không thể tạo tài khoản.");
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.printf(
                    "[LỖI] SQLState: %s%nThông báo: %s%n",
                    e.getSQLState(),
                    e.getMessage()
            );
            return false;
        }
    }
}