package oop;

public class Rectangle extends Shape {
    private final double width, height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Sides must be positive");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}
