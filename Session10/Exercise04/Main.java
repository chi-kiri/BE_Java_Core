package Exercise04;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Circle(3.0)
        };

        double totalArea = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            double area = shape.getArea();
            totalArea += area;

            result.append(String.format(
                    "| %d. [%-20s] | Diện tích: %.2f cm2%n",
                    i + 1,
                    shape.getName(),
                    area
            ));
        }

        System.out.printf("""
                --- KHỞI TẠO MẢNG ĐA HÌNH 3 SHAPES ---

                +-------------------------------------------------------+
                |             THỐNG KÊ DIỆN TÍCH BẢN VẼ CAD            |
                +-------------------------------------------------------+
                %s|-------------------------------------------------------|
                | -> TỔNG DIỆN TÍCH BẢN VẼ: %.2f cm2
                +-------------------------------------------------------+
                """,
                result,
                totalArea);
    }
}
