package ch05;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch05_01 {
    public static void main(String[] args) {
        String[] fileNames = new String[] {
                "./.test/nosuchfileexists.txt",
                "./.test/5.1.testWithIncorrectInput.txt",
                "./.test/5.1.testWithCorrectInput.txt"
        };
        Ch05_01 cl = new Ch05_01();

        for (int i = 0; i < fileNames.length; i++) {
            System.out.print(i + 1 + ". ");
            try {
                ArrayList<Double> result = cl.readValues(fileNames[i]);
                System.out.println("Read " + result.size() + " values.");
            } catch (IOException e) {
                System.out.println("No file found or can't open it.");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number format in file.");
            }
        }

    }

    public ArrayList<Double> readValues(String filename) throws IOException, NumberFormatException {
        ArrayList<Double> arr = new ArrayList<>();
        Scanner in = new Scanner(Paths.get(filename));
        while (in.hasNext()) {
            arr.add(Double.parseDouble(in.nextLine()));
        }
        return arr;
    }
}
