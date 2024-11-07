package k_sorting_alogo;

/*
 time complexity of O(n^2)
 space complexity of O(1)
*/

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = true;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = false;
                }
            }
            if (swapped) break;
        }

    }

    public static void main(String[] args) {
        int[] array = {10,-1,1,5,7,36,79,1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
