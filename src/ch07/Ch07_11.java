package ch07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ch07_11 {
    public static void main(String[] args) {
        String sentence = "Do not stop learning Java";
        ArrayList<String> words = new ArrayList<>(List.of(sentence.split(" ")));
        Collections.shuffle(words.subList(1, words.size()-1));
        System.out.println(words);
    }
}
