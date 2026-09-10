package Exercise05;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20);

        double oldWidth = rectangle.getWidth();
        double oldHeight = rectangle.getHeight();
        double oldArea = rectangle.getArea();

        rectangle.resize(50);

        System.out.printf("""
                --- RESIZE HÌNH CHỮ NHẬT 50%% ---

                +-------------------------------------------------------+
                |             THỬ NGHIỆM PHÓNG TO HÌNH HỌC             |
                +-------------------------------------------------------+
                | [Ban đầu] Width: %.2f | Height: %.2f
                | -> Diện tích gốc:        %.2f cm2
                |-------------------------------------------------------|
                | [Sau resize +50%%] Width: %.2f | Height: %.2f
                | -> DIỆN TÍCH MỚI:        %.2f cm2
                +-------------------------------------------------------+
                """,
                oldWidth,
                oldHeight,
                oldArea,
                rectangle.getWidth(),
                rectangle.getHeight(),
                rectangle.getArea());
    }
}
