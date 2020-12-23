package ch03;

public class Ch03_10 {
    public static void main(String[] args) {
        int size = 20;
        Runnable[] tasks = new Runnable[size];
        for (int i = 0; i < size; i++) {
            int[] n = new int[]{i+1};
            tasks[i] = () -> System.out.printf("Task %d is running\n", n[0]);
            /*
                Creating intermediate one-value array is necessary to create tasks with varying number in string.
                Writing i+1 instead of n[0] will cause an error cause variables in lambda should be final or
                effectively final. "i+1" varies due to the for cycle. But "n[0]" is a link to newly created array and
                it's first element that is never changing (effectively final). Thus we hide changing i into not changing
                array link.
                You can also place one-value array definition out of cycle not to create a new array each time. But in
                this case all tasks will contain n[0] pointing to the same value of the same array,
                i.e. will bring to "Task 20 is running" result for all tasks.
            */
        }

        System.out.println("Ordered tasks execution:");
        runInOrder(tasks);
        System.out.println("Simultaneous tasks execution:");
        runTogether(tasks);

    }

    public static void runTogether(Runnable... tasks) {
        for (Runnable r: tasks) {
            new Thread(r).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i].run();
        }
    }
}
