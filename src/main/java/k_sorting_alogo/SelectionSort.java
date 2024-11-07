package k_sorting_alogo;

import java.util.Arrays;

/*
 time complexity of O(n^2)
 space complexity of O(1)
*/
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {10,-1,1,5,7,36,79,1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
