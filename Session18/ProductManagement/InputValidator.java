package ProductManagement;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidator {
    public static String inputName(Scanner scanner) {
        while (true) {
            System.out.print("Tên sản phẩm: ");
            String value = scanner.nextLine().trim();

            if (!value.isEmpty() && value.length() <= 100) {
                return value;
            }

            System.out.println("Tên sản phẩm không hợp lệ.");
        }
    }

    public static double inputPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Giá sản phẩm: ");
                double value = Double.parseDouble(scanner.nextLine());

                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số.");
            }

            System.out.println("Giá phải lớn hơn 0.");
        }
    }

    public static String inputTitle(Scanner scanner) {
        while (true) {
            System.out.print("Tiêu đề: ");
            String value = scanner.nextLine().trim();

            if (!value.isEmpty() && value.length() <= 200) {
                return value;
            }

            System.out.println("Tiêu đề không hợp lệ.");
        }
    }

    public static LocalDate inputDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ngày tạo yyyy-MM-dd: ");
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ.");
            }
        }
    }

    public static String inputCatalog(Scanner scanner) {
        while (true) {
            System.out.print("Danh mục: ");
            String value = scanner.nextLine().trim();

            if (!value.isEmpty() && value.length() <= 100) {
                return value;
            }

            System.out.println("Danh mục không hợp lệ.");
        }
    }

    public static boolean inputStatus(Scanner scanner) {
        while (true) {
            System.out.print("Trạng thái 1-Hoạt động, 0-Không hoạt động: ");
            String value = scanner.nextLine();

            if (value.equals("1")) {
                return true;
            }

            if (value.equals("0")) {
                return false;
            }

            System.out.println("Chỉ nhập 1 hoặc 0.");
        }
    }
}