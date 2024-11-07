package e_queues;

import java.util.Arrays;

public class MyQueue {

    private int[] items;
    private int front;
    private int rear;
    private int count;
    private int size;

    public MyQueue(int size) {
        this.items = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.size = size;
    }

    public void enqueue(int val) {
        if (count == size) {
            System.out.println("Queue is full!");
            return;
        }

        items[rear] = val;
        rear = (rear + 1) % size;  // Wrap around if rear exceeds size
        count++;
    }

    public int dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int temp = items[front];
        items[front] = 0;          // Optional: clear the slot
        front = (front + 1) % size;  // Wrap around if front exceeds size
        count--;
        return temp;
    }

    @Override
    public String toString() {
        return "Queue: " + Arrays.toString(items) +
                " | front=" + front +
                " | rear=" + rear +
                " | count=" + count;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();

        System.out.println(queue);
    }
}
