package ch04;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ch04_11 {
    public static void main(String[] args) {
        Class<?> cl = java.lang.System.class;
        try {
            Field f = cl.getDeclaredField("out");
            Method m = f.getType().getDeclaredMethod("println", String.class);
            m.invoke(f.get(null), "Hello, World");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
