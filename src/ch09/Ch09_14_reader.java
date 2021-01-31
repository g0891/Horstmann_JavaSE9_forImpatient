package ch09;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ch09_14_reader {
    public static void main(String[] args) {
        Ch09_14_point[] points = new Ch09_14_point[10];
        try (
                ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("./.test/pointsArray.txt")))
        )
        {
            for (int i = 0; i < 10; i++) {
                points[i] = (Ch09_14_point) in.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Ch09_14_point point:points) {
            System.out.println(point);
        }
    }

}
