package ch06;

import java.util.ArrayList;

public class Ch06_11 {
    public static void main(String[] args) {
        ArrayList<SubSubClazz> arr = new ArrayList<>();
        arr.add(null);
        arr.add(new SubSubClazz(1,2,3));
        arr.add(new SubSubClazz(3,-1,3));
        arr.add(null);
        arr.add(new SubSubClazz(-9,2,3));
        arr.add(new SubSubClazz(7,2,6));
        /*
        * minMax saves result to the Pair class of SubClazz items
        * operates over the Arraylist of elements of class SubSubClazz that extends SubClass
        * uses compareTo method of the superclass Clazz of subClazz
        * */
        Pair<SubClazz> p = Arrays.minMax(arr);
        if (p != null) {
            System.out.println(p.getFirst().a);
            System.out.println(p.getSecond().a);
        }
    }

    static class Arrays {

        public static <E extends Comparable<? super E>> E min(ArrayList<? extends E> a) {
            return extremum(a, -1);
        }

        public static <E extends Comparable<? super E>> E max(ArrayList<? extends E> a) {
            return extremum(a, 1);
        }

        private static <E extends Comparable<? super E>> E extremum(ArrayList<? extends E> a, int forMax) {
            if (a == null || a.size() == 0) return null;
            E res = null;
            E elem;
            int i = 0;
            for (; i < a.size(); i++) {
                elem = a.get(i);
                if (elem != null) {
                    res = elem;
                    break;
                }
            }
            if (res == null) return null;
            for (i++; i < a.size(); i++) {
                elem = a.get(i);
                if (elem != null && elem.compareTo(res) * forMax > 0) res = elem;
            }
            return res;
        }

        public static <E extends Comparable<? super E>> Pair<E> minMax(ArrayList<? extends E> a) {
            E min = min(a);
            if (min == null) return null;
            return new Pair<>(min, max(a));
        }
    }

    static class Pair<E extends Comparable<? super E>> {
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

class Clazz implements Comparable<Clazz> {
    int a;

    public Clazz(int a) {
        this.a = a;
    }

    @Override
    public int compareTo(Clazz obj) {
        return a - obj.a;
    }
}

class SubClazz extends Clazz{
    int b;

    public SubClazz(int a, int b) {
        super(a);
        this.b = b;
    }
}

class SubSubClazz extends SubClazz {
    int c;
    public SubSubClazz(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
}
