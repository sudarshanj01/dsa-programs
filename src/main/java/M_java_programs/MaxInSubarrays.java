package M_java_programs;

import java.util.ArrayList;
import java.util.List;


//Find the maximum element in every subarray of size k.

//Input: arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
//Output: [3, 3, 5, 5, 6, 7]
public class MaxInSubarrays {

    public static List<Integer> maxInSubarrays(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }

            res.add(max);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxInSubarrays(arr, k)); // [3, 3, 5, 5, 6, 7]
    }
}
