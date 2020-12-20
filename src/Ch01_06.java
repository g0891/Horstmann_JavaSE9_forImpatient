import java.math.BigInteger;

public class Ch01_06 {
    public static void main(String[] args) {
        System.out.println(factorial(1000).toString());
    }

    public static BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
