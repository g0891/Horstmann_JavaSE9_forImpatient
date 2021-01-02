package ch06;

import java.util.ArrayList;
import java.util.List;

public class Ch06_09 {
    public static void main(String[] args) {
        Pair<Integer> p = Arrays.firstLast(new ArrayList<>(List.of(1,2,3,4,5)));
        System.out.println(p);
    }

    static class Arrays {
        public static <E extends Comparable> Pair<E> firstLast(ArrayList<? extends E> a) {
            if (a == null || a.size() == 0) return null;
            return new Pair<>(a.get(0), a.get(a.size() - 1));
        }
    }

    static class Pair<E extends Comparable> {
        E first;
        E second;
        Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }
        E getFirst() {
            return first;
        }
        E getSecond() {
            return  second;
        }
        E max() {
            return first.compareTo(second) >= 0 ? first : second;
        }
        E min() {
            return first.compareTo(second) < 0 ? first : second;
        }
        @Override
        public String toString() {
            return "First: " + first + "\nSecond: " + second;
        }
    }
}
