package Ch01;

import java.util.Scanner;
public class Ch01_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[3];
        for (int i = 0; i <3; i++) {
            System.out.printf("Input number %d: ", i + 1);
            numbers[i] = Integer.parseInt(in.nextLine());
        }

        System.out.print("Max number: ");
        if (numbers[0] >= numbers[1] && numbers[0] >= numbers[2]) {
            System.out.println(numbers[0]);
        } else if (numbers[1] >= numbers[0] && numbers[1] >= numbers[2]) {
            System.out.println(numbers[1]);
        } else {
            System.out.println(numbers[2]);
        }

        System.out.print("Max number: " + Math.max(numbers[0], Math.max(numbers[1], numbers[2])));




    }
}
