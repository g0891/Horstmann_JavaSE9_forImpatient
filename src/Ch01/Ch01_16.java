package Ch01;

public class Ch01_16 {
    public static void main(String[] args) {
        System.out.println(average(1.0, 3.0, 5.6));
    }

    public static double average(double e, double... rest) {
        double sum = e;
        for (double d:rest) sum += d;
        return sum / (rest.length + 1);
    }
}
