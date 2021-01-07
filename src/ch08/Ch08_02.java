package ch08;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ch08_02 {
    public static void main(String[] args) throws IOException {

        /*
         * Text contained about 450_000 words.
         * Time spent for common stream: 2352
         * Time spent for parallel stream: 1604
         * */

        String text = Files.readString(Paths.get("./.test/sampleText.txt"));
        List<String> words = Arrays.asList(text.split("\\PL+"));

        System.out.println(words.stream().count());

        long time;

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            words.stream().filter(word -> word.length() > 10).count();
        }
        System.out.println("Time spent for common stream: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            words.parallelStream().filter(word -> word.length() > 10).count();
        }
        System.out.println("Time spent for parallel stream: " + (System.currentTimeMillis() - time));


    }
}
