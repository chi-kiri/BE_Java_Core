package Exercise04;


public class GeometryUtils {
    public static final double PI = 3.141592653589793;

    public static double circlePerimeter(double r) {
        return 2 * PI * r;
    }

    public static double circleArea(double r) {
        return PI * r * r;
    }

    public static double cylinderVolume(double r, double h) {
        return circleArea(r) * h;
    }
}