package ch08;

import java.util.List;
import java.util.stream.Collectors;

public class Ch08_10 {
    public static void main(String[] args) {
        List<String> strings = List.of("a","aa", "aaa", "aaaa");
        double averageLength = strings.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(averageLength);
    }
}
