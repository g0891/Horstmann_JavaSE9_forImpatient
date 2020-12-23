package Ch03;

import java.util.Random;

public class Ch03_16 {
    private static Random generator = new Random();

    public static void main(String[] args) {
            IntSequence is = randomInts(2,5);
            for (int i = 0; i < 10; i++) {
                System.out.println(is.next());
            }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    public static class RandomSequence implements IntSequence{
        int low;
        int high;
        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }

    }

    public interface IntSequence {
        boolean hasNext();
        int next();
    }
}

