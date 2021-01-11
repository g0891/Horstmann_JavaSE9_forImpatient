package ch08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class Ch08_13 {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1,2,3);
        Stream<Integer> s2 = Stream.of(11,12,13,14,15);
        Stream<Integer> s3 = Stream.iterate(20, i -> i + 1);
        zip(s1,s3).limit(20).forEach(System.out::println);

    }

    public static<T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T>[] its = new Iterator[]{first.iterator(), second.iterator()};
        int[] turn = new int[]{0};
        ArrayList<T> tmp = new ArrayList<>(); tmp.add(null);
        return Stream.generate(() ->
                {
                    tmp.set(0,its[turn[0]].hasNext() ? its[turn[0]].next() : null);
                    turn[0] = (turn[0] + 1) % 2;
                    return tmp.get(0);
                }
                );


    }
}
