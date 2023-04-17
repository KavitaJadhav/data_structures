package linked_list;

public class SinglyLinkList {
    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
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

        public boolean hasNext() {
            return !(next == null);
        }
    }

    private void push(int number) {
        Node node = new Node(number);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    private void read() {
        Node node = head;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    private void pop() {
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node previousNode = head;
        Node currentNode = head;

        while (currentNode.hasNext()) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        previousNode.setNext(null);
        tail = previousNode;
        size--;
    }

    private void size() {
        System.out.println("List size: " + size);
    }

    private void unshift(int number) {

        Node node = new Node(number);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    private Object shift() {
        if (isEmpty()) return null;

        Node node = this.head;
        this.head = head.getNext();
        node.next = null;
        this.size--;
        return node.value;
    }

    private Object get(int index) {
        if (index > size) return null;

        Node node = head;
        int counter = 0;

        while (counter < index) {
            node = node.getNext();
            counter++;
        }

        return node.getValue();
    }

    private void set(int index, int value) {
        if (index > size)
            return;

        int counter = 0;
        Node node = head;

        while (counter < index) {
            node = node.getNext();
            counter++;
        }
        node.setValue(value);
    }

    private void remove(int index) {
        if (index >= size)
            return;

        if (index == 0) {
            shift();
            return;
        }

        if (index == size - 1) {
            pop();
            return;
        }

        Node node = head;
        Node preNode = null;
        int counter = 0;

        while (counter < index) {
            preNode = node;
            node = node.getNext();
            counter++;
        }

        preNode.next = node.getNext();
        if (tail == node) {
            tail = preNode;
        }
        size--;
    }

    private void insert(int index, int value) {
        if (index > size)
            return;

        if (size == 0 || index == size) {
            push(value);
            return;
        }

        Node newNode = new Node(value);
        Node nodeAtIndex = head;
        Node previousNode = null;
        int counter = 0;

        while (counter < index) {
            previousNode = nodeAtIndex;
            nodeAtIndex = nodeAtIndex.getNext();
            counter++;
        }

//        100
//        200
        newNode.next = nodeAtIndex;
        if (previousNode != null)
            previousNode.next = newNode;
        else
            head = newNode;
        size++;

    }

    private boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        SinglyLinkList list = new SinglyLinkList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.pop();
        list.shift();
        list.unshift(40);
        list.insert(0, 100);
        list.insert(1, 200);
        list.insert(2, 300);
        list.set(1, 500);
        list.remove(3);
        System.out.println(list.get(0));
        list.read();
        list.size();
        list.reverse();
        list.read();
        list.size();
    }

//    private void reverse() {
////        1,2,3,4
//
//        Node node = head;
//        head = tail;
//        tail = node;
//
//        Node pre = null;
//        Node next = null;
//
//        for (int i = 0; i < size; i++) {
//            next = node.getNext();
//            node.next = pre;
//            pre = node;
//            node = next;
//        }
//    }

    private void reverse() {
//        1 2 3 4
        Node node = head;
        head = tail;
        tail = node;

        Node pre = null;
        Node next;

        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;

        }
    }
}
