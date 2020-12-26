package ch04;

public class Ch04_03_point {
    protected double x;
    protected double y;

    public Ch04_03_point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[x=" + x + ", y=" + y + "]";
    }
}
