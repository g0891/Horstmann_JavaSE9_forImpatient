package Ch06;

import java.util.ArrayList;

public class Ch06_01 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("String 1");
        stack.push("String 2");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Stack is empty: " + stack.isEmpty());
    }

    public static class Stack<E> {
        private ArrayList<E> stack = new ArrayList<>();

        public boolean isEmpty() {
            return stack.size() == 0;
        }

        public void push(E elem) {
            stack.add(elem);
        }

        public E pop() {
            return stack.size() == 0 ? null : stack.remove(stack.size() - 1);
        }
    }
}
