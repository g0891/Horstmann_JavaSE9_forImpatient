package ch07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Ch07_12 {
    public static void main(String[] args) {
        String sentence = "Do. Not. Stop. Learning. Java.";
        ArrayList<String> words = new ArrayList<>(List.of(sentence.split(" ")));
        System.out.println(correct(words));
        Collections.shuffle(words);
        System.out.println(correct(words));

    }

    public static ArrayList<String> correct(ArrayList<String> words) {
        if (words == null || words.isEmpty()) return words;
        String first = words.get(0);
        words.set(0, first.substring(0,1).toLowerCase(Locale.ROOT) + first.substring(1));

        String last = words.get(words.size() - 1);
        words.set(words.size()-1, last.charAt(last.length() - 1) == '.' ? last.substring(0,last.length() - 1) : last);
        return words;
    }
}
