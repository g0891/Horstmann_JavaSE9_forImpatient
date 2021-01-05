package ch07;

import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;

public class Ch07_14 {
    public static void main(String[] args) {
        List<Integer> list = getList(10);
        for (Integer i:list) System.out.println(i);

    }

    public static List<Integer> getList(int n) {
        return new AbstractList<Integer>() {
            private int size = n;

            @Override
            public Integer get(int i) {
                if (i<0 || i>= size) {
                    throw new NoSuchElementException();
                }
                return i;
            }

            @Override
            public int size() {
                return size;
            }
        };
    }
}
