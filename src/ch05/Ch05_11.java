package ch05;

public class Ch05_11 {
    public static void main(String[] args) {
        factorial(5);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            System.err.println("\nStackWalker:");
            StackWalker sw = StackWalker.getInstance();
            sw.forEach(frame -> System.err.println("Frame: " + frame));

            System.err.println("\nException:");
            Exception ex = new Exception();
            ex.printStackTrace();

            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


}
