package ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ch08_07 {
    public static void main(String[] args) throws IOException {
        String text = Files.readString(Paths.get("./.test/sampletext2.txt"));
        String[] lexems = text.split("\\s");

        System.out.println("First 100 words:");
        Files.lines(Paths.get("./.test/sampletext2.txt"))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(Ch08_07::isAlphabeticWord)
                .limit(100)
                .forEach(System.out::println);

        System.out.println("\n10 most frequent words (ignoring case):");
        Files.lines(Paths.get("./.test/sampletext2.txt"))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(Ch08_07::isAlphabeticWord)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1,e2) -> Long.compare(e2.getValue(), e1.getValue())) //Sort in reverse order
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public static boolean isAlphabeticWord(String s) {
        return s != null && s.length() != 0 && s.codePoints().allMatch(Character::isAlphabetic);
    }

}
