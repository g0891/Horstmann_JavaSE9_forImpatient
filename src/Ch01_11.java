import java.util.Scanner;

public class Ch01_11 {
    public static void main(String[] args) {
        //Use a𐐀bc string as an input to check
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        int[] points = s.codePoints().toArray();
        for (int i = 0; i < points.length; i++) {
            if (points[i] >= 128) {
                System.out.println(new String(Character.toChars(points[i])) + " " + points[i]);
            }
        }
    }
}
