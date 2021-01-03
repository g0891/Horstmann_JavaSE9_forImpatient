package ch07;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ch07_03 {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>(Set.of("Cat", "Dog"));
        HashSet<String> set2 = new HashSet<>(Set.of("Cat", "Monkey"));
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);


        HashSet<String> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        HashSet<String> intersection = new HashSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        HashSet<String> difference = new HashSet<>();
        difference.addAll(set1);
        difference.removeAll(set2);
        System.out.println("Difference (Set1 - Set2): " + difference);

        HashSet<String> difference2 = new HashSet<>();
        difference2.addAll(set2);
        difference2.removeAll(set1);
        System.out.println("Difference (Set2 - Set1): " + difference2);

    }
}
