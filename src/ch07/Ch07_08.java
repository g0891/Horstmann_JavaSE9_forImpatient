package ch07;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Ch07_08 {
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(Paths.get("./.test/words.txt"));
        } catch (IOException ex) {
            System.out.println("IO exception caught. Perhaps no file is found or it is inaccessible.");
            return;
        }

        Map<String, Set<Integer>> map = new TreeMap<>();
        int[] line = new int[]{0};
        while (in.hasNext()) {
            line[0]++;
            Arrays.stream(in.nextLine().split(" ")).
                    forEach(word -> map.compute(word, (k, v) -> {
                        if (v == null) {
                            return new TreeSet<>(Set.of(line[0]));
                        } else {
                            v.add(line[0]);
                            return v;
                        }
                    }
                    ));
        }

        //Show the result
        for (Map.Entry<String, Set<Integer>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
