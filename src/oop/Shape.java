package oop;

/** Abstract base class: every shape must know its area and perimeter. */
public abstract class Shape implements Comparable<Shape> {
    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public abstract double perimeter();

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(area(), other.area());
    }

    @Override
    public String toString() {
        return String.format("%s (area=%.2f, perimeter=%.2f)", name, area(), perimeter());
    }
}
