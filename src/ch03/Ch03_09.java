package ch03;

public class Ch03_09 {
    public static void main(String[] args) {
        Runnable g1 = new Greeter(10, "Ann");
        Runnable g2 = new Greeter(15, "John");
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        t1.start();
        t2.start();

    }

    static class Greeter implements Runnable {
        int n;
        String target;

        public Greeter(int n, String target) {
            this.n = n;
            this.target = target;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                System.out.println("Hello, " + target);
            }
        }
    }
}
