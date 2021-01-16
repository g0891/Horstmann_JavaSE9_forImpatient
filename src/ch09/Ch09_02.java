package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Ch09_02 {
    public static void main(String[] args) throws IOException{
        createTokenFile(Paths.get("./.test/words.txt"));
    }

    public static void createTokenFile(Path path) throws IOException {
        Path tocFile = Paths.get(
                path.getParent().toString(),
                path.getFileName().toString().lastIndexOf('.') == -1 ?
                        path.getFileName().toString() + ".toc" :
                        path.getFileName().toString().substring(0,path.getFileName().toString().lastIndexOf('.')) + ".toc"
        );

        Map<String, Set<Long>> map = new TreeMap<>();
        long lineNumber = 0;
        String[] words;

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
             PrintWriter pw = new PrintWriter(Files.newBufferedWriter(tocFile, StandardCharsets.UTF_8)))
        {
            Iterator<String> it = lines.iterator();
            while (it.hasNext()) {
                lineNumber++;
                words = it.next().split("\\PL+");
                for (String word: words) {
                    if (!map.containsKey(word)) {
                        map.put(word, new TreeSet<Long>(List.of(lineNumber)));
                    } else {
                        map.get(word).add(lineNumber);
                    }
                }
            }
            for (Map.Entry<String, Set<Long>> word: map.entrySet()) {
                pw.println(word.getKey() + " " + word.getValue().toString());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
