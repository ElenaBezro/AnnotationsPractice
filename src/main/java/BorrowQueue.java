import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BorrowQueue {
    private Queue<Book> bookQueue;
    private Queue<Book> bookPriorityQueue;
    public BorrowQueue() {
        bookQueue = new LinkedList<>();
        bookPriorityQueue = new PriorityQueue<>();
    }

    public void add(Book book) {
        bookQueue.add(book);
        bookPriorityQueue.add(book);
    }
    public Book removeQueue() {
        return bookQueue.poll();
    }
    public Book removePriorityQueue() {
        return bookPriorityQueue.poll();
    }

    public void processQueue() {
        while (!bookQueue.isEmpty()) {
            bookQueue.poll();
            System.out.println("The book was borrowed. Remaining books: " + bookQueue);
        }
        System.out.println("The borrowing queue is empty.");
    }
    public void processPriorityQueue() {
        while (!bookPriorityQueue.isEmpty()) {
            bookPriorityQueue.poll();
            System.out.println("The book was borrowed from PriorityQueue. Remaining books: " + bookPriorityQueue);
        }
        System.out.println("The borrowing PriorityQueue is empty.");
    }
}
