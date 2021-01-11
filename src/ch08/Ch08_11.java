package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Ch08_11 {
    public static void main(String[] args) throws IOException {
        long max = Files.lines(Paths.get("./.test/words2.txt"))
                .mapToInt(String::length).max().orElse(0);

        List<String> list = Files.lines(Paths.get("./.test/words2.txt"))
                .filter(word -> word.length() == max).collect(Collectors.toList());

        list.stream().limit(10).forEach(System.out::println);
    }
}
