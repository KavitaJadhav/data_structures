package stack;

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);

        System.out.println(stack.peek());
    }
}
