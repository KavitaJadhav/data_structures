//| Operation  | Method              | Time     |
//| ---------- | ------------------- | -------- |
//| Insert     | `add()` / `offer()` | O(log n) |
//| Get top    | `peek()`            | O(1)     |
//| Remove top | `poll()`            | O(log n) |

package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(2);
        minHeap.offer(1);
        System.out.println(minHeap.poll());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(1);
        maxHeap.offer(2);
        System.out.println(maxHeap.poll());
    }
}
