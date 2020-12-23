package ch02;

public class Ch02_06 {

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Point pNew = p.translate(1, 3).scale(0.5);
        System.out.println(p.toString());
        System.out.println(pNew.toString());

    }

    public static class Point {
        private double x;
        private double y;

        public Point() {};
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public Point translate(double a, double b) {
            x += a;
            y += b;
            return this;
        }

        public Point scale(double s) {
            x *= s;
            y *= s;
            return this;
        }

        public String toString() {
            return String.format("(%.2f; %.2f)", x, y);
        }
    }
}
