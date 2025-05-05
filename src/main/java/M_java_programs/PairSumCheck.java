package M_java_programs;

import java.util.HashSet;

public class PairSumCheck {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int compliment = target - num;
            if (seen.contains(compliment)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
    }

}
