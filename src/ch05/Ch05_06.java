package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ch05_06 {
    public static void main(String[] args) {

    }

    public void f1(Path path) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            // read from in
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.err.println("Caught IOException while closing 'in': " + ex.getMessage());
                }
            }
        }
    }

    public void f2(Path path) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                // read from in
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    public void f3(Path path) {
        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            // read from in
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
