package ch04;

public class Ch04_01 {
    public static void main(String[] args) {
        LabeledPoint lp = new LabeledPoint("MyLabel", 1, 2);
        System.out.println(lp.getX());
        System.out.println(lp.getY());
        System.out.println(lp.getLabel());
    }


}

class Point {
    private double x;
    private double y;

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
}

class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return  label;
    }
}
