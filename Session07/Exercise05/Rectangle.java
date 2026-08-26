package Exercise05;

public class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        if (width <= 0) {
            System.out.println("[Cảnh báo Constructor] Chiều rộng không hợp lệ (" + width + " <= 0), tự động gán width = 1.0");
            this.width = 1.0;
        } else {
            this.width = width;
        }

        if (height <= 0) {
            System.out.println("[Cảnh báo Constructor] Chiều dài không hợp lệ (" + height + " <= 0), tự động gán height = 1.0");
            this.height = 1.0;
        } else {
            this.height = height;
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void displayRectangleInfo() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             THÔNG SỐ KỸ THUẬT HÌNH CHỮ NHẬT          |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Chiều rộng: %.2f m | Chiều dài: %.2f m%n", width, height);
        System.out.printf("| -> CHU VI:    %.2f m%n", getPerimeter());
        System.out.printf("| -> DIỆN TÍCH: %.2f m2%n", getArea());
        System.out.println("+-------------------------------------------------------+");
    }
}