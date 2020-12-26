package ch04_for03task;

public class Ch04_03 {
    public static void main(String[] args) {
        LabeledPoint03 lp1 = new LabeledPoint03("My label", 1, 2);
        System.out.println(lp1); // possible due to usage of x and y from extending class even from the other package
        //System.out.println(lp1.x); // impossible due to the protected x and trying to access from another package not from extending class
    }
}

class LabeledPoint03 extends ch04.Ch04_03_point {
    private String label;

    public LabeledPoint03(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return  label;
    }

    public String toString() {
        return getClass().getName() + "[label=" + label + ", x=" + x + ", y=" + y + "]";
    }
}
