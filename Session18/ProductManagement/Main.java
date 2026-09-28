package ProductManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductDAO productDAO = new ProductDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("""
                    
                    ******************** PRODUCT MANAGEMENT ********************
                    1. Danh sách sản phẩm
                    2. Thêm mới sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm theo tên sản phẩm
                    6. Sắp xếp sản phẩm theo giá tăng dần
                    7. Thống kê số lượng sản phẩm theo danh mục
                    8. Thoát
                    ************************************************************
                    Lựa chọn: 
                    """);

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập từ 1 đến 8.");
                continue;
            }

            switch (choice) {
                case 1:
                    displayProducts(productDAO.findAll());
                    break;

                case 2:
                    addProduct(scanner);
                    break;

                case 3:
                    updateProduct(scanner);
                    break;

                case 4:
                    deleteProduct(scanner);
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    displayProducts(productDAO.searchByName(scanner.nextLine()));
                    break;

                case 6:
                    displayProducts(productDAO.sortByPrice());
                    break;

                case 7:
                    productDAO.statisticByCatalog();
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        Product product = new Product();

        product.setProductName(InputValidator.inputName(scanner));
        product.setProductPrice(InputValidator.inputPrice(scanner));
        product.setProductTitle(InputValidator.inputTitle(scanner));
        product.setProductCreated(InputValidator.inputDate(scanner));
        product.setProductCatalog(InputValidator.inputCatalog(scanner));
        product.setProductStatus(InputValidator.inputStatus(scanner));

        if (productDAO.add(product)) {
            System.out.println("Thêm sản phẩm thành công.");
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = new Product();

        product.setProductId(id);
        product.setProductName(InputValidator.inputName(scanner));
        product.setProductPrice(InputValidator.inputPrice(scanner));
        product.setProductTitle(InputValidator.inputTitle(scanner));
        product.setProductCreated(InputValidator.inputDate(scanner));
        product.setProductCatalog(InputValidator.inputCatalog(scanner));
        product.setProductStatus(InputValidator.inputStatus(scanner));

        if (productDAO.update(product)) {
            System.out.println("Cập nhật sản phẩm thành công.");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productDAO.delete(id)) {
            System.out.println("Xóa sản phẩm thành công.");
        }
    }

    private static void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm.");
            return;
        }

        System.out.printf(
                "%-5s | %-20s | %-15s | %-20s | %-12s | %-15s | %-12s%n",
                "ID",
                "TÊN",
                "GIÁ",
                "TIÊU ĐỀ",
                "NGÀY TẠO",
                "DANH MỤC",
                "TRẠNG THÁI"
        );

        System.out.println(
                "--------------------------------------------------------------------------------------------------------------"
        );

        for (Product product : products) {
            String status;

            if (product.isProductStatus()) {
                status = "Hoạt động";
            } else {
                status = "Ngừng";
            }

            System.out.printf(
                    "%-5d | %-20s | %,15.2f | %-20s | %-12s | %-15s | %-12s%n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getProductPrice(),
                    product.getProductTitle(),
                    product.getProductCreated(),
                    product.getProductCatalog(),
                    status
            );
        }
    }
}