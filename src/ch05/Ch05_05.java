package ch05;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch05_05 {
    public static void main(String[] args) {
        new Ch05_05().method("1","2");
    }

    public void method(String fileIn, String fileOut) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(fileIn));
            out = new PrintWriter(fileOut);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while executing application.");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {

                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception ex) {

                }
            }
        }
    }
}
