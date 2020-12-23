package ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ch02_10 {
    public static void main(String[] args) {
        Random rand = new Random(System.nanoTime());

        int[] arr = new int[] {1, 2, 3};
        ArrayList<Integer> arrList = new ArrayList<>(List.of(4,5,6));

        System.out.println(RandomNumbers.nextInt(rand, arr));
        System.out.println(RandomNumbers.nextInt(rand, arrList));
    }

}

class RandomNumbers {
    public static int nextInt(Random generator, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else {
            return arr[generator.nextInt(arr.length)];
        }
    }

    public static int nextInt(Random generator, ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        } else {
            return arr.get(generator.nextInt(arr.size()));
        }
    }
}
