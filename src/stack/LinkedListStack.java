//Time Complexity
// insert - -O(1)
// delete -O(1)
// read - O(n)
// Search - O(n)

//Space Complexity
//O(n)

package stack;

public class LinkedListStack {
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

    private Object pop() {
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

    private void push(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();
        stack.pop();
        stack.print();
    }
}
