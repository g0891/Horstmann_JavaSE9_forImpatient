package ch09;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;

public class Ch09_01 {
    public static void main(String[] args) {
        try (InputStream in = Files.newInputStream(Paths.get("./.test/words.txt"));
             OutputStream out = Files.newOutputStream(Paths.get("./.test/words_new.txt"),
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND))
        {
            copy(in, out);
        } catch (IOException ex) {
            System.out.println("Error copying stream");
            ex.printStackTrace();
        }

        try (InputStream in = Files.newInputStream(Paths.get("./.test/words.txt"));
             OutputStream out = Files.newOutputStream(Paths.get("./.test/words_new2.txt"),
                     StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND))
        {
            copy2(in, out);
        } catch (IOException ex) {
            System.out.println("Error copying stream");
            ex.printStackTrace();
        }

    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        in.transferTo(out);
    }

    public static void copy2(InputStream in, OutputStream out) throws IOException {
        Path path = Paths.get("./.test/tmpfile");
        Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(path, out);
        Files.delete(path);
    }
}
