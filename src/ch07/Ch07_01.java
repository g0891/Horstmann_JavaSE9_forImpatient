package ch07;

import java.util.*;

public class Ch07_01 {
    public static void main(String[] args) {
        int n = 50;

        //Creating sets
        Set<Integer> set = new HashSet<>();
        BitSet bSet = new BitSet();

        //Initializing sets
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }
        bSet.set(2,n);

        //Clearing sets from non-prime numbers
        int s = 2;
        while (s * s <= n) {
            int elem = s * s;
            while (elem <= n) {
                set.remove(elem);
                bSet.clear(elem);
                elem += s;
            }
            s += 1;
        }

        //Output
        System.out.println(set);
        System.out.println(bSet);
    }
}
