package ch01;

public class Ch01_08 {
    public static void main(String[] args) {
        String s = "12345";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                System.out.println(s.substring(i, j + 1));
            }
        }
    }
}
