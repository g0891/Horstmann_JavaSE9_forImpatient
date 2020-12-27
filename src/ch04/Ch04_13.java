package ch04;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class Ch04_13 {
    public static void main(String[] args) throws Exception{
        generateTable(Class.forName("java.lang.Math").getMethod("sqrt", double.class), 1, 16, 1);
        System.out.println();
        generateTable(Class.forName("java.lang.Double").getMethod("toHexString", double.class), 1, 16, 1);

        System.out.println("\n");

        generateTable2(Math::sqrt, 1, 16, 1);
        System.out.println();
        generateTable2(Double::toHexString, 1, 16, 1);


        System.out.println();
        try {
            Method m = Class.forName("java.lang.Math").getMethod("max", double.class, double.class);
            generateTable(m, 1, 16, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    static void generateTable(Method m, double min, double max, double step) throws Exception{
        if (m == null
                || !Modifier.isStatic(m.getModifiers())
                || m.getParameters().length != 1
                || m.getParameters()[0].getType() != double.class && m.getParameters()[0].getType() != Double.class
        )
            throw new Exception("Illegal method provided: " + (m == null ? "" : m.getDeclaringClass().getCanonicalName() + "." + m.getName()));
        if (max < min || step <= 0)
            throw new Exception("Incorrect boundaries or step.");
        for (double val = min; val <= max; val += step){
            System.out.println(val + " : " + m.invoke(null, val));
        }
    }

    static void generateTable2(DoubleFunction<Object> f, double min, double max, double step) throws Exception{
        if (max < min || step <= 0)
            throw new Exception("Incorrect boundaries or step.");
        for (double val = min; val <= max; val += step){
            System.out.println(val + " : " + f.apply(val));
        }
    }
}
