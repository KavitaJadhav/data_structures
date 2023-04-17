package linked_list;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    class Node {
        private int value;
        Node next;
        Node prev;

        public Node(int number) {
            this.value = number;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public boolean hasPrev() {
            return this.prev != null;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }

    private void size() {
        System.out.println("List size: " + size);
    }

    private Object pop() {
        if (isEmpty()) return null;

        Node node = tail;
        if (size == 1) {
            size--;
            head = null;
            tail = null;
            return node.value;
        }

        tail = node.prev;
        tail.next = null;

        size--;
        return node.value;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void read() {
        Node node = head;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    private void push(int number) {
        Node node = new Node(number);

        if (isEmpty()) {
            head = node;
            tail = node;
            size++;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    private void reverse() {
        Node node = head;
        head= tail;
        tail = head;

        Node prev;
        Node next;

        while (node != null) {
           next = node.next;
           prev = node.prev;

           node.next = prev;
           node.prev = next;

           node = next;

        }
    }

    private Object get(int index) {
        if (index >= size) return null;

        int counter = 0;
        Node node = head;
        while (counter != index) {
            node = node.next;
            counter++;
        }
        return node.value;
    }

    private void remove(int index) {
        if (index >= size) return;

        if (index == 0) {
            shift();
            return;
        }

        if (index == size - 1) {
            pop();
            return;
        }

        Node node = head;
        int counter = 0;

        while (counter != index) {
            node = node.next;
            counter++;
        }
//1,2,3,4

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    private void set(int index, int number) {
        if (index >= size) return;

        Node node = head;
        int counter = 0;

        while (counter != index) {
            node = node.next;
            counter++;
        }
        node.setValue(number);
    }

    private void insert(int index, int number) {
//        Todo: Fix logic
        if (index > size) return;

        if (index == size) {
            push(number);
            return;
        }
        if (index == 0) {
            unshift(number);
            return;
        }

        Node newNode = new Node(number);
        Node nodeAtIndex = head;
        int counter = 0;

        while (counter != index) {
            nodeAtIndex = nodeAtIndex.next;
            counter++;
        }

        newNode.prev = nodeAtIndex.prev;
        newNode.next = nodeAtIndex;
        nodeAtIndex.prev.next = newNode;
        nodeAtIndex.prev = newNode;
        size++;
    }

    private void unshift(int number) {
        if (isEmpty()) {
            push(number);
            return;
        }

        Node node = new Node(number);

        node.next = head;
        head = node;
        size++;
    }

    private void shift() {
        if (size == 1) {
            pop();
            return;
        }
        Node node = head;
        head = node.next;
        node.next = null;
        size--;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 100);
        list.insert(1, 200);
        list.insert(2, 300);
        list.insert(3, 400);
        list.read();
        list.size();
        list.shift();
        list.size();
        list.unshift(40);
        list.unshift(50);

        list.remove(0);
//        list.reverse();
        list.read();
        list.size();

//        list.set(0, 500);
//        list.remove(3);
//        System.out.println(list.get(0));
        list.reverse();
    }
}
