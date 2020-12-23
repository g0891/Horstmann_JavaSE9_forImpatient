package Ch03;

import java.math.BigInteger;

public class Ch03_06 {

    public static void main(String[] args) {
        SquareSequence sq = new SquareSequence();
        for (int i = 0; sq.hasNext() && i < 20; i++) {
            System.out.println(sq.next());
        }
    }

    interface Sequence<T> {
        boolean hasNext();
        T next();
    }

    static class SquareSequence implements Sequence<BigInteger> {
        private BigInteger number = BigInteger.ZERO;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            number = number.add(BigInteger.ONE);
            return number.pow(2);
        }
    }
}
