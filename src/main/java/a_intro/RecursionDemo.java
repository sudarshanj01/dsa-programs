package a_intro;

/**
 * This program demonstrates three recursive methods:
 * 1. `fact`: Calculates the factorial of a number (e.g., 5! = 5 * 4 * 3 * 2 * 1 = 120).
 * 2. `test1`: Creates a number by appending digits from 1 to n (e.g., 5 becomes 12345).
 * 3. `test2`: Sums numbers from 1 to n (e.g., sum of 1 to 5 = 1 + 2 + 3 + 4 + 5 = 15).
 */
public class RecursionDemo {
    public static int fact(int n) {
        if (n <= 1) return 1;   // Base case
        return n * fact(n - 1); // Recursive case
    }

    public static int test1(int n) {
        if (n == 1) return 1; // Base case
        // Recursive case: builds the number by appending digits
        return (int) (n * Math.pow(10, (int) Math.log10(test1(n - 1)) + 1) + test1(n - 1));
    }

    public static int test2(int n) {
        if (n <= 1) return 1; // Base case
        return n + test2(n - 1); // Recursive case: sum of numbers from 1 to n
    }

    public static void main(String[] args) {
        System.out.println(fact(5));   // Output: 120
        System.out.println(test1(5));  // Output: 12345
        System.out.println(test2(5));  // Output: 15
    }
}
