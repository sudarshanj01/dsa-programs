package l_javaInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Programs {
    public static void main(String[] args) {
        Programs programs = new Programs();

        LinkedList<Integer> sample = new LinkedList<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);

        System.out.println(programs.reverseLL(sample));

    }

    public LinkedList<Integer> reverseLL(LinkedList<Integer> ogList) {
        LinkedList<Integer> result = new LinkedList<>();

        // Create a copy to avoid modifying the original during iteration
        LinkedList<Integer> copy = new LinkedList<>(ogList);

        // Remove from the end of copy and add to result
        while (!copy.isEmpty()) {
            result.add(copy.removeLast());
        }

        return result;
    }

    private boolean anagram(String s1, String s2) {
        if (s1.trim().length() != s2.trim().length()) return false;

        char[] s1Array = s1.trim().toCharArray();
        char[] s2Array = s2.trim().toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }

    public boolean palindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }



}