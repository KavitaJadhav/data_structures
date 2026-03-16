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
        ArrayListQueue queue = new ArrayListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}
