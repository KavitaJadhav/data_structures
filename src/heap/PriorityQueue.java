//This is Example of BinaryMinHeap

package heap;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    private List<Task> tasks = new ArrayList<>();

    private static class Task {
        private final String task;
        private final int priority;

        public Task(int priority, String task) {
            this.priority = priority;
            this.task = task;
        }
    }

    private void read() {
        tasks.stream().map(task -> "Priority: " + task.priority + " task: " + task.task).forEach(System.out::println);
    }

    private void enqueue(Task task) {
        tasks.add(task);
        bubbleUp(tasks.size() - 1);
    }

    private void bubbleUp(int index) {
        if (index == 0) return;
        int parentIndex = index / 2;
        int childPriority = tasks.get(index).priority;
        int parentPriority = tasks.get(parentIndex).priority;

        if (childPriority < parentPriority) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void dequeue() {
        Task queued = tasks.remove(0);
        if (tasks.size() <= 1) return;

        int lastIndex = tasks.size() - 1;
        Task lastTask = tasks.remove(lastIndex);
        tasks.add(0, lastTask);
        bubbleDown(0);
        System.out.println("Dequeued task - priority: " + queued.priority + " task: " + queued.task);
    }

    private void bubbleDown(int index) {
//Todo: Refactor logic;
        int leftChildIndex = (index * 2) + 1;
        int rightChildIndex = (index * 2) + 2;

        int priority = tasks.get(index).priority;
        int leftChildPriority;
        int rightChildPriority;

        if (leftChildIndex < tasks.size() && rightChildIndex < tasks.size()) {
            leftChildPriority = tasks.get(leftChildIndex).priority;
            rightChildPriority = tasks.get(rightChildIndex).priority;

            if (priority > leftChildPriority || priority > rightChildPriority) {
                if (leftChildPriority < rightChildPriority) {
                    swap(index, leftChildIndex);
                    bubbleDown(leftChildIndex);
                } else {
                    swap(index, rightChildIndex);
                    bubbleDown(rightChildIndex);
                }
            }
        }

        if (leftChildIndex >= tasks.size() && rightChildIndex < tasks.size()) {
            rightChildPriority = tasks.get(rightChildIndex).priority;
            if (priority > rightChildPriority) {
                swap(index, rightChildIndex);
                bubbleDown(rightChildIndex);
            }
        }

        if (rightChildIndex >= tasks.size() && leftChildIndex < tasks.size()) {
            leftChildPriority = tasks.get(leftChildIndex).priority;
            if (priority > leftChildPriority) {
                swap(index, leftChildIndex);
                bubbleDown(leftChildIndex);
            }
        }
    }

    private void swap(int index1, int index2) {
        Task temp = tasks.get(index1);
        tasks.set(index1, tasks.get(index2));
        tasks.set(index2, temp);
    }

    public static void main(String[] args) {
        PriorityQueue heap = new PriorityQueue();
        heap.enqueue(new Task(3, "Order grocery"));
        heap.enqueue(new Task(2, "Walk dog"));
        heap.enqueue(new Task(4, "Replace chair"));
        heap.enqueue(new Task(1, "Book dentist appointment"));

        heap.read();
        heap.dequeue(); //Remove root/max
        heap.dequeue(); //Remove root/max
        heap.read();
    }
}
