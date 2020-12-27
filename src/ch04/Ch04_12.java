package ch04;

import java.lang.reflect.Method;

public class Ch04_12 {
    public static void main(String[] args) throws Exception{
        Test testInstance = new Test();
        Method m = Test.class.getMethod("testMethod");

        long testDirect = -System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            testInstance.testMethod();
        }
        testDirect += System.nanoTime();

        long testReflection = -System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            m.invoke(testInstance);
        }
        testReflection += System.nanoTime();

        System.out.println("Direct invocation took: " + testDirect + " nanoseconds.");
        System.out.println("Reflection invocation took: " + testReflection + " nanoseconds.");
        System.out.println("Direct invocation is about " + testReflection / (double) testDirect + " times faster.");

    }

    static class Test {
        public void testMethod(){
            int a = 2 + 2;
        }
    }
}
