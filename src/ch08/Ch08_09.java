package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch08_09 {
    public static void main(String[] args) throws IOException {
        List<String> vowels = List.of("a","e","i","o","u");

        List<String> list = Files.lines(Paths.get("./.test/words2.txt"))
                .map(String::toLowerCase)
                .filter(word -> {
                            Set<String> set = Stream.of(word.split("")).collect(Collectors.toSet());
                            set.retainAll(vowels);
                            return set.size() == 5;
                        })
                .collect(Collectors.toList());

        list.stream().limit(10).forEach(System.out::println);
    }
}
