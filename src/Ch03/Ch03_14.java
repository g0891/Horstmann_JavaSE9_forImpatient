package Ch03;

public class Ch03_14 {
    public static void main(String[] args) {
        Runnable[] tasks = new Runnable[] {
                () -> System.out.println("Hello!"),
                () -> System.out.println("1"),
                () -> System.out.println("2"),
                () -> System.out.println("3"),
                () -> System.out.println("Bye!"),
        };

        Runnable combinedTask = runAll(tasks);
        combinedTask.run();

    }

    public static Runnable runAll(Runnable[] tasks) {
        return () -> {
            for (int i = 0; i < tasks.length; i++) {
                tasks[i].run();
            }
        };
    }
}
