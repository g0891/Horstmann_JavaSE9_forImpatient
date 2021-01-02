package ch06;

import java.lang.reflect.Array;

public class Ch06_21 {
    public static void main(String[] args) {
        Integer[] arr= Arrays.<Integer>construct(10);
        System.out.println(arr.length + " " + arr.getClass().getSimpleName());
    }

    static class Arrays {
        @SafeVarargs
        @SuppressWarnings("unchecked")
        public static <T> T[] construct(int n, T... noValue) {
            return (T[]) Array.newInstance(noValue.getClass().getComponentType(), n);
        }
    }
}
