package ch06;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Ch06_22 {

    public static void main(String[] args) {

    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Exception, T> constructor) throws T {
        try {
            return c.call();
        } catch (Exception e) {
            throw constructor.apply(e);
        }
    }
}
