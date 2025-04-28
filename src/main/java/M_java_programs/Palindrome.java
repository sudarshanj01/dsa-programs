package M_java_programs;

public class Palindrome {
    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        char[] inputChars = input.toCharArray();

        int left = 0;
        int right = inputChars.length - 1;

        while (left < right) {
            if (inputChars[left] != inputChars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }

}
