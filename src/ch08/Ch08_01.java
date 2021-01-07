package ch08;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch08_01 {
    public static void main(String[] args) {
        String[] words = new String[]
                {"longword1", "short1", "longword2", "longword3", "short2", "longword4", "longword5", "longword6", "longword7", "longword8"};
        ArrayList<String> arr = Stream.of(words).filter(word -> {
            System.out.println("filtering word: " + word);
            return word.length()>8;
        }).limit(5).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Words collected: " + arr);
    }
    
}
