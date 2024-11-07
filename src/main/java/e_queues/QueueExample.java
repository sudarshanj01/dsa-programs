package e_queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 1. Add elements to the queue using add()
        queue.add("Apple");   // Throws exception if it fails
        queue.add("Banana");
        queue.add("Cherry");

        // 2. Add an element using offer() (alternative to add)
        queue.offer("Date");   // Returns false if it fails, no exception

        // 3. Peek at the front element without removing it
        String frontElement = queue.peek();
        System.out.println("Peek front element: " + frontElement);

        // 4. Remove the front element (poll/dequeue)
        String removedElement = queue.poll();
        System.out.println("Removed front element: " + removedElement);

        // 5. Remove an element using remove() (throws exception if empty)
        String removedWithRemove = queue.remove();
        System.out.println("Removed element with remove(): " + removedWithRemove);

        // 6. Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty);

        // 7. Size of the queue
        int size = queue.size();
        System.out.println("Queue size: " + size);
    }
}
