Day 4: Data Structures - Queue
Objective: Introduce Queues by implementing a book borrowing queue.
Requirements:Create a BorrowQueue class that holds a queue of books that members wish to borrow.
Implement methods to add a book to the queue and to process the queue.

Tasks:Use LinkedList or PriorityQueue to implement the book borrowing queue.
Implement enqueue and dequeue operations.

Exercise 2
NodeQueue: Constructor

Create a Queue class that represents a queue data structure using nodes.
Implement the constructor and instance variables as follows:
Create a private instance variable first that will store a reference to the first node in the queue.
Create a private instance variable last that will store a reference to the last node in the queue.
Create a private instance variable length that will store the current length of the queue.
Create a nested Node class with an integer value and a reference to the next Node in the queue.
Implement a constructor for the Queue class that takes an integer value as an argument, creates a new Node with the given value, and initializes the first, last, and length instance variables.
public class Queue {

	// CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
	//                                                          //
	//                                                          //
	//                                                          //
	//                                                          //
	//////////////////////////////////////////////////////////////
   

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
        while (temp != null) {
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

}
exercise 3
Queue: Enqueue
Implement the enqueue method for the Queue class, which adds a new node to the end of the queue.

Return type: void
The method should perform the following tasks:
Accept an integer value as an argument, which will be the value of the new node.
Create a new Node object called newNode with the given value.
If the length of the queue is 0, set both the first and last pointers of the queue to newNode.
If the length of the queue is greater than 0, perform the following tasks: a. Set the next attribute of the current last node to newNode. b. Update the last pointer of the queue to point to newNode.
Increment the length attribute of the queue by 1.


