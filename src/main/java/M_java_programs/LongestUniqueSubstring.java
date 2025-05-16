package M_java_programs;

import java.util.HashSet;

//Find the length of the longest substring without repeating characters.
//Input: "abcabcbb" → Output: 3 (Longest: "abc")
//Input: "bbbbb" → Output: 1
//Input: "pwwkew" → Output: 3 (Longest: "wke")

public class LongestUniqueSubstring {


    public static String longestUniqueSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();

        int left = 0, right = 0, maxLen = 0, start = 0;

        while (right < s.length()) {
            if (!set.contains(ch[right])) {
                set.add(ch[right]);

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }

                right++;
            } else {
                set.remove(ch[left]);
                left++;
            }
        }

        return s.substring(start, start + maxLen);

    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb")); // "abc"
        System.out.println(longestUniqueSubstring("bbbbb"));    // "b"
        System.out.println(longestUniqueSubstring("pwwkew"));   // "wke"
    }
}


