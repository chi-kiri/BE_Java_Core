package Exercise02;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SubjectManager<Subject> manager = new SubjectManager<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Chọn chức năng:
                    1. Hiển thị danh sách môn học
                    2. Thêm môn học
                    3. Xóa môn học
                    4. Tìm kiếm môn học theo tên
                    5. Lọc môn học theo tín chỉ
                    6. Thoát
                    """);

            int choice = inputInteger("Chọn: ");

            switch (choice) {
                case 1:
                    manager.displaySubjects();
                    break;
                case 2:
                    addSubject();
                    break;
                case 3:
                    removeSubject();
                    break;
                case 4:
                    searchSubject();
                    break;
                case 5:
                    manager.filterByCredits();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }

    public static void addSubject() {
        System.out.print("Nhập mã môn học: ");
        String code = scanner.nextLine();

        System.out.print("Nhập tên môn học: ");
        String name = scanner.nextLine();

        int credits = inputCredits();

        System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
        String startDate = scanner.nextLine();

        Subject subject = new Subject(code, name, credits, startDate);

        manager.addSubject(subject);
    }

    public static void removeSubject() {
        System.out.print("Nhập mã môn học cần xóa: ");
        String code = scanner.nextLine();

        manager.removeSubject(code);
    }

    public static void searchSubject() {
        System.out.print("Nhập tên môn học cần tìm: ");
        String name = scanner.nextLine();

        manager.searchByName(name);
    }

    public static int inputInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    public static int inputCredits() {
        while (true) {
            try {
                System.out.print("Nhập số tín chỉ: ");
                int credits = Integer.parseInt(scanner.nextLine());

                if (credits < 0 || credits > 10) {
                    throw new IllegalArgumentException(
                            "Số tín chỉ phải nằm trong khoảng từ 0 đến 10!"
                    );
                }

                return credits;
            } catch (NumberFormatException e) {
                System.out.println("Số tín chỉ phải là số nguyên!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
