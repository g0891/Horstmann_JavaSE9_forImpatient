package ch05;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch05_04 {
    public static void main(String[] args) {
        String[] fileNames = new String[] {
                "./.test/nosuchfileexists.txt",
                "./.test/5.1.testWithIncorrectInput.txt",
                "./.test/5.1.testWithCorrectInput.txt"
        };
        Ch05_04 cl = new Ch05_04();

        for (int i = 0; i < fileNames.length; i++) {
            System.out.print(i + 1 + ". ");
            SumOfValuesResult res = cl.sumOfValues(fileNames[i]);
            switch (res.status) {
                case SUCCESS:
                    System.out.println(res.sum);
                    break;
                case BAD_NUMBER_FORMAT:
                    System.out.println("Incorrect number format in file.");
                    break;
                case NO_FILE_FOUND:
                    System.out.println("No file found or can't open it.");
                    break;
            }
        }
    }

    public SumOfValuesResult sumOfValues(String filename) {
        ReadResult readResult = readValues(filename);
        if (readResult.status != Status.SUCCESS) {
            return new SumOfValuesResult(readResult.status, Double.NaN);
        }
        return new SumOfValuesResult(Status.SUCCESS,
                readResult.arrayList.stream().mapToDouble(d -> d.doubleValue()).sum());

    }

    public ReadResult readValues(String filename) {
        ArrayList<Double> arr = new ArrayList<>();
        try {
            Scanner in = new Scanner(Paths.get(filename));
            while (in.hasNext()) {
                arr.add(Double.parseDouble(in.nextLine()));
            }
        } catch (IOException e) {
            return new ReadResult(Status.NO_FILE_FOUND, null);
        } catch (NumberFormatException e) {
            return new ReadResult(Status.BAD_NUMBER_FORMAT, null);
        }
        return new ReadResult(Status.SUCCESS, arr);
    }

    class ReadResult{
        Status status;
        ArrayList<Double> arrayList;
        public ReadResult(Status status, ArrayList<Double> arrayList) {
            this.status = status;
            this.arrayList = arrayList;
        }
    }

    class SumOfValuesResult {
        Status status;
        double sum;
        public SumOfValuesResult(Status status, double sum) {
            this.status = status;
            this.sum = sum;
        }
    }

    enum Status {SUCCESS, NO_FILE_FOUND, BAD_NUMBER_FORMAT}
}
