package ch07;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch07_07 {
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(Paths.get("./.test/words.txt"));
        } catch (IOException ex) {
            System.out.println("IO exception caught. Perhaps no file is found or it is inaccessible.");
            return;
        }

        Map<String, Integer> map = new TreeMap<>(); //TreeMap to display words in alphabetical order
        while (in.hasNext()) {
            Arrays.stream(in.next().split(" ")).forEach(word -> map.compute(word, (k,v) -> v == null ? 1 : v + 1));
        }

        //Show the result
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }


}
