//Time Complexity
// insert - -O(1)
// delete -O(1)
// read - O(n)
// Search - O(n)

//Space Complexity
//O(n)

package queue;

public class LinkedListQueue {
    private int size = 0;
    private Node head;
    private Node tail;

    class Node {

        private final int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
        }

    }

    private void print() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private Object dequeue() {
        if (isEmpty())
            return null;
        Node lastNode = tail;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = lastNode.prev;
            lastNode.prev = null;
            tail.next = null;
        }

        size--;
        return lastNode.value;
    }

    private void enqueue(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;

        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}
