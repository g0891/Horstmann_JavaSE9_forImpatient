package ch05;

import java.io.IOException;
import java.util.ArrayList;

public class Ch05_02 {
    public static void main(String[] args) {
        String[] fileNames = new String[] {
                "./.test/nosuchfileexists.txt",
                "./.test/5.1.testWithIncorrectInput.txt",
                "./.test/5.1.testWithCorrectInput.txt"
        };
        Ch05_02 cl = new Ch05_02();

        for (int i = 0; i < fileNames.length; i++) {
            System.out.print(i + 1 + ". ");
            try {
                System.out.println(cl.sumOfValues(fileNames[i]));
            } catch (IOException e) {
                System.out.println("No file found or can't open it.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number format in file.");
            }
        }
    }

    public double sumOfValues(String filename) throws IOException, NumberFormatException {
        ArrayList<Double> arr = new Ch05_01().readValues(filename);
        return arr.stream().mapToDouble(d -> d.doubleValue()).sum();
    }
}
