package ch04;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Ch04_09 {
    public static void main(String[] args) {
        TestClass1 obj = new TestClass1();
        System.out.println(toString(obj));
    }

    static String toString(Object o) {
        StringBuilder sb = new StringBuilder();
        Class<?> cl = o.getClass();
        for (Field f: cl.getDeclaredFields()) {
            sb.append(Modifier.toString(f.getModifiers()) + " ");
            sb.append(f.getType() + " ");
            sb.append(f.getName() + ":");
            try {
                sb.append(f.get(o));
            } catch (Exception e) {
                try {
                    f.setAccessible(true);
                    sb.append(f.get(o));
                } catch (Exception e2) {
                    sb.append("Inaccessible field");
                }

            }
            sb.append("\n");
        }
        return sb.toString();
    }

    static class TestClass1 {
        private int a = 1;
        protected String s = "hello";
        public ArrayList<Double> arrayList = new ArrayList<>(List.of(1.0,2.0,3.0));
    }
}


