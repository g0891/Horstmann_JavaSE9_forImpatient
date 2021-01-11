package ch08;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch08_16 {
    static BigInteger startInt = BigInteger.TEN.pow(50);
    static BigInteger endInt = startInt.multiply(BigInteger.TEN);

    public static void main(String[] args) {
        long time;

        time = System.nanoTime();
        List<BigInteger> list = getNewStream().filter(bi -> bi.isProbablePrime(100)).limit(500).collect(Collectors.toList());
        System.out.println("Time passed for sequential stream: " + (System.nanoTime() - time));

        time = System.nanoTime();
        List<BigInteger> list2 = getNewStream().parallel().filter(bi -> bi.isProbablePrime(100)).limit(500).collect(Collectors.toList());
        System.out.println("Time passed for parallel   stream: " + (System.nanoTime() - time));
    }

    public static Stream<BigInteger> getNewStream() {
        return Stream.iterate(startInt, val -> val.compareTo(endInt) < 0, val -> val.add(BigInteger.ONE));
    }
}
