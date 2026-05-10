package queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class javaQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        System.out.println(queue.poll());

        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.offer(2);
        minQueue.offer(1);
        System.out.println(minQueue.poll());

        Queue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        maxQueue.offer(1);
        maxQueue.offer(2);
        System.out.println(maxQueue.poll());
    }
}
