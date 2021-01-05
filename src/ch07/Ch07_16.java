package ch07;

import java.util.*;
import java.util.function.IntFunction;

public class Ch07_16 {
    public static void main(String[] args) {
        List<Integer> list = getList(x -> x * x);
        for (int i = 0; i < 7; i++) {
            System.out.println(list.get(i));

        }

        System.out.println(list.get(2));
        System.out.println(list.get(6));
        System.out.println(list.get(8));



    }

    public static <T> AbstractList<T> getList(IntFunction<T> func) {
        return new AbstractList<T>() {
            LinkedHashMap<Integer,T> cache = new LinkedHashMap<>() {
              @Override
              protected boolean removeEldestEntry(Map.Entry eldest) {
                  return size() > 5;
              }
            };

            @Override
            public T get(int i) {
                if (cache.containsKey(i)) {
                    //System.out.println("Returning value from cache.");
                    return cache.get(i);
                } else {
                    //System.out.println("Calculating new value.");
                    T tmp = func.apply(i);
                    cache.put(i,tmp);
                    return func.apply(i);
                }
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
