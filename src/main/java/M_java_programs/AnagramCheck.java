package M_java_programs;

import java.util.Arrays;

public class AnagramCheck {

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) return false;

        // Remove spaces and make lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths differ, can't be anagram
        if (str1.length() != str2.length()) return false;

        // Convert to char arrays and sort
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));     // true
        System.out.println(isAnagram("Triangle", "Integral")); // true
        System.out.println(isAnagram("hello", "world"));       // false
    }
}
