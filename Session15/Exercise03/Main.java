package Exercise03;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    static Map<String, Order> orders = new LinkedHashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    ================ MENU ================
                    1. Thêm sản phẩm
                    2. Xóa sản phẩm
                    3. Hiển thị sản phẩm
                    4. Tạo đơn hàng
                    5. Thêm sản phẩm vào đơn hàng
                    6. Hiển thị đơn hàng
                    0. Thoát
                    ======================================
                    """);

            int choice = inputInteger("Lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    createOrder();
                    break;
                case 5:
                    addProductToOrder();
                    break;
                case 6:
                    displayOrders();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void addProduct() {
        try {
            int id = inputInteger("Nhập ID sản phẩm: ");

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (price <= 0) {
                throw new IllegalArgumentException(
                        "Giá sản phẩm phải lớn hơn 0!"
                );
            }

            products.add(new Product(id, name, price));

            System.out.println("Thêm sản phẩm thành công!");
        } catch (NumberFormatException e) {
            System.out.println("Giá sản phẩm phải là một số hợp lệ!");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static void removeProduct() {
        try {
            int id = inputInteger("Nhập ID sản phẩm cần xóa: ");

            Product product = findProductById(id);

            products.remove(product);

            System.out.println("Xóa sản phẩm thành công!");
        } catch (ProductNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static Product findProductById(int id)
            throws ProductNotFoundException {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        throw new ProductNotFoundException(
                "Không tìm thấy sản phẩm có ID: " + id
        );
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }

        System.out.println("Danh sách sản phẩm:");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void createOrder() {
        int orderId = inputInteger("Nhập mã đơn hàng: ");
        String key = String.valueOf(orderId);

        if (orders.containsKey(key)) {
            System.out.println("Mã đơn hàng đã tồn tại!");
            return;
        }

        orders.put(key, new Order(orderId));

        System.out.println("Tạo đơn hàng thành công!");
    }

    public static void addProductToOrder() {
        try {
            int orderId = inputInteger("Nhập mã đơn hàng: ");
            String key = String.valueOf(orderId);

            if (!orders.containsKey(key)) {
                throw new OrderNotFoundException(
                        "Không tìm thấy đơn hàng có mã: " + orderId
                );
            }

            int productId = inputInteger("Nhập ID sản phẩm: ");

            Product product = findProductById(productId);
            Order order = orders.get(key);

            order.addProduct(product);

            System.out.println("Thêm sản phẩm vào đơn hàng thành công!");
        } catch (OrderNotFoundException | ProductNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống!");
            return;
        }

        System.out.println("Danh sách đơn hàng:");

        for (Map.Entry<String, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();

            System.out.println("--------------------------------------");
            System.out.println("Mã đơn hàng: " + order.getOrderId());

            if (order.getProducts().isEmpty()) {
                System.out.println("Đơn hàng chưa có sản phẩm.");
            } else {
                for (Product product : order.getProducts()) {
                    System.out.println(product);
                }
            }

            System.out.printf(
                    "Tổng tiền: %,.2f VNĐ%n",
                    order.getTotalPrice()
            );
        }
    }

    public static int inputInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Lỗi: Bạn phải nhập một số nguyên hợp lệ!"
                );
            }
        }
    }
}
