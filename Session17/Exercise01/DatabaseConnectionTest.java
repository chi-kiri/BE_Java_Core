package Exercise01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionTest {
    private static final String DB_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();

        try (InputStream input = DatabaseConnectionTest.class
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

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            DatabaseMetaData metaData = conn.getMetaData();

            System.out.printf("""
                    ==================================================
                      KIỂM TRA KẾT NỐI POSTGRESQL - RIKKEI ERP DB
                    ==================================================
                    [THÀNH CÔNG] Kết nối CSDL PostgreSQL thành công!
                    --------------------------------------------------
                    Tên hệ quản trị CSDL : %s
                    Phiên bản CSDL       : %s
                    Tên JDBC Driver      : %s
                    Phiên bản Driver     : %s
                    --------------------------------------------------
                    ==================================================
                                  KẾT THÚC KIỂM TRA
                    ==================================================
                    """,
                    metaData.getDatabaseProductName(),
                    metaData.getDatabaseProductVersion(),
                    metaData.getDriverName(),
                    metaData.getDriverVersion());

        } catch (SQLException e) {
            System.out.printf("""
                    ==================================================
                      KIỂM TRA KẾT NỐI POSTGRESQL - RIKKEI ERP DB
                    ==================================================
                    [THẤT BẠI] Không thể kết nối đến PostgreSQL!
                    SQLState      : %s
                    Thông báo lỗi : %s
                    ==================================================
                    """,
                    e.getSQLState(),
                    e.getMessage());
        }
    }
}
