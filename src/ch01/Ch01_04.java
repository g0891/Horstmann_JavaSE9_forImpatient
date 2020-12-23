package ch01;

public class Ch01_04 {
    public static void main(String[] args) {
        System.out.println("Lowest positive double value: " + Math.nextUp(0.0));
        System.out.println("Highest positive double value: " + Math.nextDown(Double.POSITIVE_INFINITY));
    }

}
