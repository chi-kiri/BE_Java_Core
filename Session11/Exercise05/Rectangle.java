package Exercise05;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void resize(double percent) {
        width *= (1 + percent / 100);
        height *= (1 + percent / 100);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
