package queueClassImplementation;

public class OwnQueue {
    private Node first;
    private Node last;
    private int length = 0;
    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public OwnQueue(int value) {
        Node node = new Node(value);
        first = node;
        last = node;
        length = 1;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (length == 0) {
            first = node;
            last = node;
            length = 1;
        }
        else {
            last.next = node;
            last = node;
            length++;
        }


    }
}


