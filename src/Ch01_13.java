import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Ch01_13 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random generator = new Random(System.nanoTime());
        for (int i = 1; i <= 49; i++) {
            list.add(i);
        }

        int[] result = new int[6];
        for (int i = 0; i < 6; i++) {
            result[i] = list.remove(generator.nextInt(list.size()));
        }

        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }
}
