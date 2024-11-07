package k_sorting_alogo;

import java.util.Arrays;

/*
 time complexity of O(n^2)
 space complexity of O(1)
*/
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {10,-1,1,5,7,36,79,1};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
