package a_intro;

/**
 * The logic involves extracting each bit, determining its power of 2, and summing the results.
 * For example, binary 1010 = 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0 = 8 + 0 + 2 + 0 = 10.
 * lastDigit = num % 10
 */
public class BinaryToDecimal {

    public static int convert(int binary) {
        int result = 0;
        int power = 0;

        while (binary != 0) {
            int lastDigit = binary % 10;
            if (lastDigit == 1) {
                result += (int) Math.pow(2, power);
            }
            power++;
            binary = binary / 10;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(convert(1010));  // Output: 10
    }
}
