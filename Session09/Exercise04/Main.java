package Exercise04;

public class Main {
    public static void main(String[] args) {
        double r = 5.0;
        double h = 10.0;

        double perimeter = GeometryUtils.circlePerimeter(r);
        double area = GeometryUtils.circleArea(r);
        double volume = GeometryUtils.cylinderVolume(r, h);

        System.out.printf("""
                --- TIỆN ÍCH TÍNH TOÁN HÌNH HỌC GEOMETRY UTILS ---
                Bán kính r = %.1f, Chiều cao h = %.1f

                +-------------------------------------------------------+
                |           BÁO CÁO THỐNG KÊ HÌNH HỌC ĐƯỜNG TRÒN       |
                +-------------------------------------------------------+
                | Bán kính (r):             %.2f cm
                | Chiều cao trụ (h):        %.2f cm
                |-------------------------------------------------------|
                | CHU VI HÌNH TRÒN:         %.2f cm
                | DIỆN TÍCH HÌNH TRÒN:      %.2f cm2
                | THỂ TÍCH HÌNH TRỤ:        %.2f cm3
                +-------------------------------------------------------+
                """,
                r,
                h,
                r,
                h,
                perimeter,
                area,
                volume
        );
    }
}
