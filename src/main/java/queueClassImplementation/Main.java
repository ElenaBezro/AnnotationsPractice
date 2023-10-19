package queueClassImplementation;

public class Main {
    public static void main(String[] args) {

        OwnQueue myQueue = new OwnQueue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        myQueue.printAll();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();

    }
}