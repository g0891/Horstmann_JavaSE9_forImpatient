package ch04;

public class Ch04_05 {
    public static void main(String[] args) {
        Circle05 circle1 = new Circle05(new Ch04_03_point(0,0), 1);
        Circle05 circle2 = circle1.clone();
        circle1.moveBy(2,2);
        System.out.println(circle1.getCenter());
        System.out.println(circle2.getCenter());
    }
}

abstract class Shape05 {
    protected Ch04_03_point point;

    protected Shape05(Ch04_03_point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point.x += dx;
        point.y += dy;
    }

    abstract public Ch04_03_point getCenter();


}

class Circle05 extends Shape05 {
    private double radius;
    public Circle05(Ch04_03_point center, double radius) {
        super(center);
        this.radius = radius;
    }

    public Ch04_03_point getCenter() {
        return point;
    }

    public Circle05 clone() {
        return new Circle05(new Ch04_03_point(point.x, point.y), radius);
    }
}

class Rectangle05 extends Shape05 {
    private double width;
    private double height;
    public Rectangle05(Ch04_03_point leftTop, double width, double height) {
        super(leftTop);
        this.width = width;
        this.height = height;
    }
    public Ch04_03_point getCenter() {
        return new Ch04_03_point(point.x + width / 2, point.y - height / 2);
    }

    public Rectangle05 clone() {
        return new Rectangle05(new Ch04_03_point(point.x, point.y), width, height);
    }
}

class Line05 extends Shape05 {
    private Ch04_03_point to;
    public Line05(Ch04_03_point from, Ch04_03_point to) {
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

    public Line05 clone() {
        return new Line05(new Ch04_03_point(point.x, point.y), new Ch04_03_point(to.x, to.y));
    }
}
