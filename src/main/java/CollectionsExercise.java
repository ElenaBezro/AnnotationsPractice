import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CollectionsExercise {

    void addToEndOfLinkedList(LinkedList<Integer> numbers, int i) {
        numbers.add(i);
    }

    void addToStartOfLinkedList(LinkedList<Integer> numbers, int i) {
        numbers.addFirst(i);
    }

    void removeItemFromTopOfStack(Deque<Integer> stack) {
        stack.remove();
    }

    void removeItemFromFrontOfQueue(Queue<Integer> queue) {
        queue.remove();
    }


}
