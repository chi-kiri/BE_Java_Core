package Exercise06;

public class Main {
    public static void main(String[] args) {
        Point2D pointA = new Point2D(1.5, 2.0);
        Point2D pointB = new Point2D(4.5, 6.0);

        double distance = pointA.distanceTo(pointB);

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|         BÁO CÁO KHOẢNG CÁCH EUCLID TỌA ĐỘ GIS        |");
        System.out.println("+-------------------------------------------------------+");

        System.out.print("| Tọa độ Điểm nguồn A:      ");
        pointA.displayPoint();
        System.out.println();

        System.out.print("| Tọa độ Điểm đích B:       ");
        pointB.displayPoint();
        System.out.println();

        System.out.println("|-------------------------------------------------------|");
        System.out.printf("| KHOẢNG CÁCH ĐƯỜNG CHIM BAY (A -> B): %.2f đơn vị%n", distance);
        System.out.println("+-------------------------------------------------------+");
    }
}