package ch07;

import java.util.*;

public class Ch07_06 {
    public static void main(String[] args) {
        HashMap<String,HashSet<Integer>> map = new HashMap<>(Map.of("A", new HashSet<>(List.of(1,2)), "B", new HashSet<>(List.of(3,4))));
        method(map);
    }

    public static void method(Map<String, HashSet<Integer>> map) {
        System.out.println("All keys:");
        for (String s:map.keySet()) {
            System.out.println(s);
        }

        System.out.println("All items for 'A':");
        for (Integer el:map.get("A")) {
            System.out.println(el);
        }

        /*
        Everything seems to be fine.
        Output produced:
            All keys:
            A
            B
            All items for 'A':
            1
            2
        */
    }
}
