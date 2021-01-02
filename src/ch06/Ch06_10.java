package ch06;

import java.util.ArrayList;
import java.util.List;

public class Ch06_10 {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,0, -9, -1));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(null);
        arr.add(1);
        arr.add(3);
        arr.add(null);
        arr.add(-9);
        arr.add(7);
        System.out.println(Arrays.max(arr));
        System.out.println(Arrays.min(arr));
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


    }
}
