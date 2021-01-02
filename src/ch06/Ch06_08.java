package ch06;

public class Ch06_08 {
    public static void main(String[] args) {
        Ch06_08.Pair<Integer> p = new Ch06_08.Pair<>(10,20);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
        System.out.println(p.max());
        System.out.println(p.min());
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
    }

}
