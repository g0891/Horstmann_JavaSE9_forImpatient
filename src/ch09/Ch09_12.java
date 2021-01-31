package ch09;

import java.util.regex.Pattern;

public class Ch09_12 {
    public static void main(String[] args) {
        String s = "John Fitzgerald Kennedy; John Andrew Brown; Ann Claire Brook";
        String shortString = Pattern.compile("(?<firstName>\\w+) (?<middleName>\\w+) (?<lastName>\\w+)")
                .matcher(s)
                .replaceAll("${firstName} ${lastName}");
        System.out.println(shortString);
    }
}
