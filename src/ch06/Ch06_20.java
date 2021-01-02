package ch06;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ch06_20 {
    public static void main(String[] args) {
        String[] arr = repeat(2, "a", "b", "c");
        System.out.println(Arrays.toString(arr));
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static final <T> T[] repeat(int n, T... obj) {
        T[] arr = (T[]) Array.newInstance(obj.getClass().getComponentType(), n * obj.length);
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = obj[i];
            }
        }
        return arr;
    }
}
