package stack;

import java.util.ArrayList;
import java.util.List;


public class ArrayStack {
    private List<Object> values = new ArrayList<Object>();

    private void print() {
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    private Object pop() {
        return values.remove(values.size() - 1);
    }

    private void push(int value) {
        values.add(value);
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.print();
    }
}
