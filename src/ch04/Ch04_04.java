package ch04;

public class Ch04_04 {
    public static void main(String[] args) {
        System.out.println("Circle:");
        Circle circle = new Circle(new Ch04_03_point(0,0), 5);
        System.out.println(circle.getCenter());
        circle.moveBy(1, 2);
        System.out.println(circle.getCenter());

        System.out.println("Rectangle:");
        Rectangle rectangle = new Rectangle(new Ch04_03_point(0,0), 7, 3);
        System.out.println(rectangle.getCenter());
        rectangle.moveBy(3,4);
        System.out.println(rectangle.getCenter());

        System.out.println("Line:");
        Line line = new Line(new Ch04_03_point(0,0), new Ch04_03_point(8,4));
        System.out.println(line.getCenter());
        line.moveBy(1, 10);
        System.out.println(line.getCenter());
    }
}

abstract class Shape {
    protected Ch04_03_point point;

    protected Shape(Ch04_03_point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point.x += dx;
        point.y += dy;
    }

    abstract public Ch04_03_point getCenter();
}

class Circle extends Shape {
    private double radius;
    public Circle(Ch04_03_point center, double radius) {
        super(center);
        this.radius = radius;
    }

    public Ch04_03_point getCenter() {
        return point;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(Ch04_03_point leftTop, double width, double height) {
        super(leftTop);
        this.width = width;
        this.height = height;
    }
    public Ch04_03_point getCenter() {
        return new Ch04_03_point(point.x + width / 2, point.y - height / 2);
    }
}

class Line extends Shape {
    private Ch04_03_point to;
    public Line(Ch04_03_point from, Ch04_03_point to) {
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx,dy);
        to.x += dx;
        to.y += dy;
    }
    public Ch04_03_point getCenter() {
        return new Ch04_03_point((point.x + to.x) / 2, (point.y + to.y) / 2);
    }
}
