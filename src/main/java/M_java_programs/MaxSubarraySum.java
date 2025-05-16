package M_java_programs;


//Find the maximum sum of a contiguous subarray (aka Maximum Subarray Problem).

//Input: arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//Output: 6 → subarray [4, -1, 2, 1] has the maximum sum 6
public class MaxSubarraySum {

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Compare current element vs extending the current subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr)); // Output: 6
    }
}
