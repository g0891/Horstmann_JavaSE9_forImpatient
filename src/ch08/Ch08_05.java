package ch08;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch08_05 {
    public static void main(String[] args) {
        String s = "a\uD801\uDC00bc";
        System.out.println("String length in chars: " + s.length());
        System.out.println("String length in code points: " + codePoints(s).count());
        System.out.println("Symbols:");
        codePoints(s).forEach(System.out::println);
    }

    public static Stream<String> codePoints(String s) {
        return IntStream.iterate(0, i -> i < s.length(), i -> s.offsetByCodePoints(i, 1))
                .map(s::codePointAt)
                .mapToObj(cp -> new String(Character.toChars(cp)));
    }
}
