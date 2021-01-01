package ch06;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Ch06_02 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println();

        Stack2<Integer> stack2 = new Stack2<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

    }

    public static class Stack<E> {
        private E[] stack;
        private int items;

        public Stack() {
            stack = newStack(4);
        }

        @SuppressWarnings("unchecked")
        private E[] newStack(int n) {
            return (E[]) new Object[n];
        }

        public boolean isEmpty() {
            return items == 0;
        }

        public void push(E elem) {
            if (items == stack.length) {
                E[] newStack = newStack(stack.length * 2);
                for (int i = 0; i < stack.length; i++) {
                    newStack[i] = stack[i];
                }
                stack = newStack;
            }
            stack[items++] = elem;
        }

        public E pop() {
            return items == 0 ? null : stack[--items];
        }
    }

    public static class Stack2<E> {
        private Object[] stack;
        private int items;

        public Stack2() {
            stack = new Object[4];
        }

        public boolean isEmpty() {
            return items == 0;
        }

        public void push(E elem) {
            if (items == stack.length) {
                Object[] newStack = new Object[stack.length * 2];
                for (int i = 0; i < stack.length; i++) {
                    newStack[i] = stack[i];
                }
                stack = newStack;
            }
            stack[items++] = elem;
        }

        @SuppressWarnings("unchecked")
        public E pop() {
            return items == 0 ? null : (E) stack[--items];
        }
    }

}


