package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ch08_17 {
    public static void main(String[] args) throws IOException {
        List<String> words = Files.lines(Paths.get("./.test./war-and-peace.txt")).flatMap(line -> Arrays.stream(line.split("\\PL+"))).collect(Collectors.toList());
        long time;
        int[] max = new int[1];
        List<String> list;

        time = System.nanoTime();
        max[0]  = words.stream().mapToInt(s -> s.length()).max().orElse(0);
        list = words.stream().filter(word -> word.length() == max[0]).limit(500).collect(Collectors.toList());
        System.out.println(System.nanoTime()-time);

        time = System.nanoTime();
        max[0]  = words.parallelStream().mapToInt(s -> s.length()).max().orElse(0);
        list = words.parallelStream().filter(word -> word.length() == max[0]).limit(500).collect(Collectors.toList());
        System.out.println(System.nanoTime()-time);
    }
}
