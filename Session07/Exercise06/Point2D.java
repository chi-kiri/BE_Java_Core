package Exercise06;

public class Point2D {
    double x;
    double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point2D other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2)
                + Math.pow(this.y - other.y, 2));
    }

    public void displayPoint() {
        System.out.printf("(%.2f, %.2f)", x, y);
    }
}