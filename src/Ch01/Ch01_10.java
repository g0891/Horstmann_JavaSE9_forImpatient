package Ch01;

import java.util.Random;

public class Ch01_10 {
    public static void main(String[] args) {
        Random generator = new Random(System.nanoTime());
        Long l = generator.nextLong();
        System.out.println(Long.toString(l, 36));
    }
}
