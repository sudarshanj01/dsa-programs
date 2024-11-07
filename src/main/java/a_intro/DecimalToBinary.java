package a_intro;

/**
 * num & 1 = last bit
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        int dec = 23;
        String result = "";

        while (dec != 0) {
            int lastBit = dec & 1;  // Extract the last bit
            result = lastBit + result;  // Append the bit to the result
            dec = dec >> 1;  // Shift right to process the next bit
        }

        System.out.println(result);  // Output: 10111
    }
}
