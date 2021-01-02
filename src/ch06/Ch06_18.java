package ch06;

import java.util.function.IntFunction;

public class Ch06_18 {
    public static void main(String[] args) {
        Integer[] arrInteger = repeat(10,42,Integer[]::new);
        Boolean[] arrBoolean = repeat(10, true, Boolean[]::new);
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) {
            result[i] = obj;
        }
        return result;

    }
}
