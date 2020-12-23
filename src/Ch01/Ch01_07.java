package Ch01;

import java.util.Scanner;

public class Ch01_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input 1st number: ");
        short n1 = (short) Integer.parseInt(in.nextLine());
        System.out.print("Input 2nd number: ");
        short n2 = (short) Integer.parseInt(in.nextLine());

        System.out.println(Short.toUnsignedInt((short) (n1 + n2)));
        System.out.println(Short.toUnsignedInt((short) (n1 - n2)));
        System.out.println(Short.toUnsignedInt((short) (n1 * n2)));
        System.out.println(Short.toUnsignedInt(n1) / Short.toUnsignedInt(n2));
        System.out.println(Short.toUnsignedInt(n1) % Short.toUnsignedInt(n2));
    }
}
