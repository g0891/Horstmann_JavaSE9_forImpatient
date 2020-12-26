package ch04;

import java.util.Objects;

public class Ch04_02 {
    public static void main(String[] args) {
        Point02 p1 = new Point02(1,2);
        Point02 p2 = new Point02(1,2);
        Point02 p3 = null;
        Point02 p4 = new Point02(1,3);

        System.out.println(p1);
        System.out.println("Supposed to be true, actually: " + p1.equals(p1));
        System.out.println("Supposed to be false, actually: " + p1.equals(p3));
        System.out.println("Supposed to be false, actually: " + p1.equals("123"));
        System.out.println("Supposed to be false, actually: " + p1.equals(p4));
        System.out.println("Supposed to be true, actually: " + p1.equals(p2));
        System.out.println("Supposed to be true, actually: " + (p1.hashCode() == p2.hashCode()));
        System.out.println("Supposed to be false, actually: " + (p1.hashCode() == p4.hashCode()));


        LabeledPoint02 lp1 = new LabeledPoint02("My label",1,2);
        LabeledPoint02 lp2 = new LabeledPoint02("My label",1,2);
        LabeledPoint02 lp3 = null;
        LabeledPoint02 lp4 = new LabeledPoint02("My new label",1,2);

        System.out.println(lp1);
        System.out.println("Supposed to be true, actually: " + lp1.equals(lp1));
        System.out.println("Supposed to be false, actually: " + lp1.equals(lp3));
        System.out.println("Supposed to be false, actually: " + lp1.equals("123"));
        System.out.println("Supposed to be false, actually: " + lp1.equals(lp4));
        System.out.println("Supposed to be true, actually: " + lp1.equals(lp2));
        System.out.println("Supposed to be true, actually: " + (lp1.hashCode() == lp2.hashCode()));
        System.out.println("Supposed to be false, actually: " + (lp1.hashCode() == lp4.hashCode()));
    }
}

class Point02 {
    private double x;
    private double y;

    public Point02(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return this.getClass().getName() + "[x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Point02 tempPoint = (Point02) o;
        return Double.compare(x, tempPoint.x) == 0 && Double.compare(y, tempPoint.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class LabeledPoint02 extends Point02 {
    private String label;

    public LabeledPoint02(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return  label;
    }

    @Override
    public String toString() {
        return super.toString() + "[label=" + label + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        LabeledPoint02 tempLabeledPoint = (LabeledPoint02) o;
        return label == null && tempLabeledPoint == null || label != null && label.equals(tempLabeledPoint.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label.hashCode());
    }
}