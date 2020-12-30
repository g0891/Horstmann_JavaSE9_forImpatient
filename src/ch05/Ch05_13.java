package ch05;

import java.util.Arrays;
import java.util.OptionalInt;

public class Ch05_13 {
    public static void main(String[] args) {
        // To compare execution time run app with 'ea' key and then run without 'ea' key.
        long start = System.nanoTime();
        System.out.println(new Ch05_13().min(new int[1000000] ));
        System.out.println(System.nanoTime() - start);
    }

    public int min(int[] values) {
        if (values == null) throw new IllegalArgumentException("Array is not initialized.");
        if (values.length == 0) throw new IllegalArgumentException("Array has no entries.");
        OptionalInt minValue = Arrays.stream(values).min();
        assert Arrays.stream(values).allMatch(i -> i >= minValue.getAsInt());
        return minValue.getAsInt();
    }
}
