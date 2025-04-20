package l_javaInterview;

import java.util.Arrays;

public class Programs {
    public static void main(String[] args) {
        Programs programs = new Programs();
        System.out.println(programs.anagram("sdc", "dcs"));

        System.out.println(programs.palindrome("madam"));

        System.out.println(new StringBuilder(new String("sudarshan")).reverse());

        String og = "suarsha";

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