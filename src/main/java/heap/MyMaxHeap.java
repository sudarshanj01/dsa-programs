package heap;

public class MyMaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MyMaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Helper methods to get indices
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Helper method to swap elements
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new element into the heap
    public void insert(int element) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }

        // Insert new element at the end
        heap[size] = element;

        // Heapify up (bubble up the element to its correct position)
        int current = size;
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

        size++;
    }

    // Remove and return the maximum element
    public int extractMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the maximum value to return
        int max = heap[0];

        // Move the last element to root and remove the last element
        heap[0] = heap[size - 1];
        size--;

        // Heapify down (sink down the root to its correct position)
        heapifyDown(0);

        return max;
    }

    // Heapify down process
    private void heapifyDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Compare with left child
        if (left < size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }

        // Compare with right child
        if (right < size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }

        // If largest is not root
        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    // Get the maximum element without removing it
    public int peekMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Get current size of heap
    public int getSize() {
        return size;
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}