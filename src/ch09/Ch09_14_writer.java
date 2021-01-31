package ch09;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ch09_14_writer {
    public static void main(String[] args) {
       Ch09_14_point[] points = new Ch09_14_point[10];
        for (int i = 0; i < 10; i++) {
            points[i] = new Ch09_14_point(i,100+i);
        }
        try (
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("./.test/pointsArray.txt")));
            )
        {
            for (Ch09_14_point point : points) {
                out.writeObject(point);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
