package ch06;

public class Ch06_07 {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(10,20);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }

    static class Pair<E> {
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
    }
}
