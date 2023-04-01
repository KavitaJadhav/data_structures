package queue;

import java.util.ArrayList;
import java.util.List;


public class ArrayListQueue {
    private List<Object> values = new ArrayList<Object>();

    private void print() {
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    private Object dequeue() {
        return values.remove(values.size() - 1);
    }

    private void enqueue(int value) {
        values.add(0, value);
    }

    public static void main(String[] args) {
        ArrayListQueue stack = new ArrayListQueue();
        stack.enqueue(10);
        stack.enqueue(20);
        stack.enqueue(30);
        stack.enqueue(40);
        stack.dequeue();
        stack.dequeue();
        stack.print();
    }
}
