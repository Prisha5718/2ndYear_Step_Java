// Shape.java
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("Shape Information:");
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

// Circle.java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle.java
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// ShapeTest.java
public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        c.displayInfo();

        Shape r = new Rectangle(4, 6);
        r.displayInfo();
    }
}
