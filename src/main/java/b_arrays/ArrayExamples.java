package b_arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExamples {

    public static void main(String[] args) {
        // Creating an array of integers
        int[] intArray = {1, 2, 3, 4, 5};

        // Creating an ArrayList of strings
        ArrayList<String> stringList = new ArrayList<>();

        // Adding elements to the ArrayList
        stringList.add("Hello");
        stringList.add("World");

        // Arrays methods
        // 1. toString() - Returns a string representation of the array
        System.out.println("Array: " + Arrays.toString(intArray));

        // 2. sort() - Sorts the array in ascending order
        Arrays.sort(intArray);
        System.out.println("Sorted Array: " + Arrays.toString(intArray));

        // 3. binarySearch() - Searches for a value in a sorted array using binary search
        int index = Arrays.binarySearch(intArray, 3);
        System.out.println("Index of 3 in array: " + index);

        // 4. copyOf() - Copies the specified array, truncating or padding with zeros if necessary
        int[] copiedArray = Arrays.copyOf(intArray, 10);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        // 5. fill() - Assigns the specified value to each element of the array
        Arrays.fill(intArray, 0);
        System.out.println("Array after fill: " + Arrays.toString(intArray));

        // 6. equals() - Checks if two arrays are equal
        boolean areEqual = Arrays.equals(intArray, copiedArray);
        System.out.println("Arrays are equal: " + areEqual);

        // ArrayList methods
        // 1. add() - Adds an element to the ArrayList
        stringList.add("!");

        // 2. get() - Retrieves an element from the ArrayList
        String firstElement = stringList.get(0);
        System.out.println("First element in list: " + firstElement);

        // 3. remove() - Removes an element from the ArrayList
        stringList.remove("World");

        // 4. size() - Returns the number of elements in the ArrayList
        int size = stringList.size();
        System.out.println("Size of list: " + size);

        // 5. contains() - Checks if the ArrayList contains a specific element
        boolean containsHello = stringList.contains("Hello");
        System.out.println("List contains 'Hello': " + containsHello);

        // 6. clear() - Removes all elements from the ArrayList
        stringList.clear();
        System.out.println("List after clear: " + stringList);
    }
}
