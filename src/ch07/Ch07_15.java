package ch07;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Ch07_15 {
    public static void main(String[] args) {
        List<Integer> list = getList(x -> x * x);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }

    }

    public static <T> List<T> getList(IntFunction<T> func) {
        return new AbstractList<T>() {
            @Override
            public T get(int i) {
                return func.apply(i);
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Integer[] toArray() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
