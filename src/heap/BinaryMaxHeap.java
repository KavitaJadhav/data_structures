
//Time complexity
//Search - O(n)
//insert -O(log n)
//delete - O(log n)

//Space complexity
//O(n)

package heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryMaxHeap {

    private List values = new ArrayList<>();

    private void read() {
        System.out.println("Values : " + values);
    }

    private void add(int value) {
        values.add(value);
        bubbleUp(values.size() - 1);
    }

    private void bubbleUp(int index) {
        if (index == 0) return;
        int parentIndex = index / 2;
        int childValue = (int) values.get(index);
        int parentValue = (int) values.get(parentIndex);

        if (childValue > parentValue) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void extractMax() {
        values.remove(0);
        if (values.size() <= 1) return;
        int lastIndex = values.size() - 1;
        Object lastValue = values.remove(lastIndex);
        values.add(0, lastValue);
        bubbleDown(0);
    }

    private void bubbleDown(int index) {
//Todo: Refactor logic;
        int leftChildIndex = (index * 2) + 1;
        int rightChildIndex = (index * 2) + 2;

        int value = (int) values.get(index);
        int leftChildValue;
        int rightChildValue;

        if (leftChildIndex > values.size() && rightChildIndex > values.size()) return;

        if (leftChildIndex < values.size() && rightChildIndex < values.size()) {
            leftChildValue = (int) values.get(leftChildIndex);
            rightChildValue = (int) values.get(rightChildIndex);

            if (value < leftChildValue || value < rightChildValue) {
                if (leftChildValue > rightChildValue) {
                    swap(index, leftChildIndex);
                    bubbleDown(leftChildIndex);
                } else {
                    swap(index, rightChildIndex);
                    bubbleDown(rightChildIndex);
                }
            }
        }

//        Unnecessary as right child will be present only if left child will be present
//        if (leftChildIndex >= values.size() && rightChildIndex < values.size()) {
//            rightChildValue = (int) values.get(rightChildIndex);
//            if (value < rightChildValue) {
//                swap(index, rightChildIndex);
//                bubbleDown(rightChildIndex);
//            }
//        }

        if (rightChildIndex >= values.size() && leftChildIndex < values.size()) {
            leftChildValue = (int) values.get(leftChildIndex);
            if (value < leftChildValue) {
                swap(index, leftChildIndex);
                bubbleDown(leftChildIndex);
            }
        }
    }

    private void swap(int index1, int index2) {
        Object temp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }

    public static void main(String[] args) {
        BinaryMaxHeap heap = new BinaryMaxHeap();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.read();
        heap.extractMax(); //Remove root/max
        heap.read();
    }

}
