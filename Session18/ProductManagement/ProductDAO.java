package ProductManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductDAO {

    private Product mapProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getDouble("product_price"),
                rs.getString("product_title"),
                rs.getDate("product_created").toLocalDate(),
                rs.getString("product_catalog"),
                rs.getBoolean("product_status")
        );
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call get_all_products(?)}")) {

                call.setString(1, "product_cursor");
                call.registerOutParameter(1, Types.REF_CURSOR);
                call.execute();

                try (ResultSet rs = (ResultSet) call.getObject(1)) {
                    while (rs.next()) {
                        products.add(mapProduct(rs));
                    }
                }

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Lỗi: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }

        return products;
    }

    public boolean add(Product product) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call add_product(?, ?, ?, ?, ?, ?)}")) {

                call.setString(1, product.getProductName());
                call.setDouble(2, product.getProductPrice());
                call.setString(3, product.getProductTitle());
                call.setDate(4, Date.valueOf(product.getProductCreated()));
                call.setString(5, product.getProductCatalog());
                call.setBoolean(6, product.isProductStatus());

                call.execute();
                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Thêm thất bại: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }

        return false;
    }

    public boolean update(Product product) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call update_product(?, ?, ?, ?, ?, ?, ?)}")) {

                call.setInt(1, product.getProductId());
                call.setString(2, product.getProductName());
                call.setDouble(3, product.getProductPrice());
                call.setString(4, product.getProductTitle());
                call.setDate(5, Date.valueOf(product.getProductCreated()));
                call.setString(6, product.getProductCatalog());
                call.setBoolean(7, product.isProductStatus());

                call.execute();
                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Cập nhật thất bại: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }

        return false;
    }

    public boolean delete(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call delete_product(?)}")) {

                call.setInt(1, id);
                call.execute();

                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Xóa thất bại: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }

        return false;
    }

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call search_product_by_name(?, ?)}")) {

                call.setString(1, name);
                call.setString(2, "search_cursor");
                call.registerOutParameter(2, Types.REF_CURSOR);
                call.execute();

                try (ResultSet rs = (ResultSet) call.getObject(2)) {
                    while (rs.next()) {
                        products.add(mapProduct(rs));
                    }
                }

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Tìm kiếm thất bại: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }

        return products;
    }

    public List<Product> sortByPrice() {
        List<Product> products = findAll();

        products.sort(Comparator.comparingDouble(Product::getProductPrice));

        return products;
    }

    public void statisticByCatalog() {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (CallableStatement call =
                         conn.prepareCall("{call statistic_product_by_catalog(?)}")) {

                call.setString(1, "statistic_cursor");
                call.registerOutParameter(1, Types.REF_CURSOR);
                call.execute();

                try (ResultSet rs = (ResultSet) call.getObject(1)) {
                    System.out.printf("%-25s | %-10s%n", "DANH MỤC", "SỐ LƯỢNG");
                    System.out.println("----------------------------------------");

                    while (rs.next()) {
                        System.out.printf(
                                "%-25s | %-10d%n",
                                rs.getString("product_catalog"),
                                rs.getInt("total")
                        );
                    }
                }

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Thống kê thất bại: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }
}