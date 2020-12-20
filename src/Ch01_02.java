import java.util.Scanner;
public class Ch01_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input angle value: ");
        int angle = in.nextInt();
        System.out.println("Normalized angle (using %): " + (angle % 360 + 360) % 360);
        System.out.println("Normalized angle (using floorMod): " + Math.floorMod(angle, 360));
    }

}
