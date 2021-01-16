package ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch09_04 {
    public static void main(String[] args) throws IOException {

        long counter;
        long time;

        counter = 0;
        time = System.nanoTime();
        try (Scanner in = new Scanner(Paths.get("./.test/war-and-peace.txt"), StandardCharsets.UTF_8)) {
            while (in.hasNextLine()) {
                in.nextLine();
                counter++;
            }
        }
        time = System.nanoTime() - time;
        System.out.println("\nUsing scanner\nLines: " + counter + " Time: " + time);

        counter = 0;
        time = System.nanoTime();
        try (BufferedReader in = Files.newBufferedReader(Paths.get("./.test/war-and-peace.txt"), StandardCharsets.UTF_8)) {
            while (in.readLine() != null) {
                counter++;
            }
        }
        time = System.nanoTime() - time;
        System.out.println("\nUsing BufferedReader and readLine\nLines: " + counter + " Time: " + time);

        counter = 0;
        time = System.nanoTime();
        try (BufferedReader in = Files.newBufferedReader(Paths.get("./.test/war-and-peace.txt"), StandardCharsets.UTF_8)) {
            counter = in.lines().count();
        }
        time = System.nanoTime() - time;
        System.out.println("\nUsing BufferedReader and lines\nLines: " + counter + " Time: " + time);


    }


}
