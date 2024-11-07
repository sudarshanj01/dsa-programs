package b_arrays;

import java.util.Arrays;

//custom implementation of Array
class MyArray {
    private int[] array;
    private int size;

    // Constructor to initialize the array with a specified capacity
    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // Method to add an element to the array
    public void add(int element) {
        if (size == array.length) {
            // If the array is full, double its capacity
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = element;
    }


    public int indexAt(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1; // Return -1 if the element is not found
    }

    // Method to remove an element from the array by its index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = 0; // Optional: Clear the last element
    }

    // Method to find the minimum value in the array
    public int findMin() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Method to find the maximum value in the array
    public int findMax() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to return a string representation of the array
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    public void reverse(){
        int i =0;
        int j = size -1;

        while (i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);

        // Adding elements to the array
        myArray.add(5);
        myArray.add(3);
        myArray.add(8);
        myArray.add(1);
        myArray.add(6);

        // Display the array
        System.out.println("Array: " + myArray);

        // Find the minimum value
        int min = myArray.findMin();
        System.out.println("Minimum value: " + min);

        // Find the maximum value
        int max = myArray.findMax();
        System.out.println("Maximum value: " + max);

        // Remove an element
        myArray.remove(2); // Remove the element at index 2
        System.out.println("Array after removal: " + myArray);

        System.out.println(myArray.indexAt(1));

        myArray.reverse();
        System.out.println(myArray);
    }
}
