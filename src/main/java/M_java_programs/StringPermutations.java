package M_java_programs;

import java.util.ArrayList;
import java.util.List;

/*
Generate all permutations of a string.

Example:
Input: "abc"
Output: [abc, acb, bac, bca, cab, cba] */
public class StringPermutations {
    public static void generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        permute("", str, result);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(newPrefix, newRemaining, result);
        }
    }

    public static void main(String[] args) {
        generatePermutations("abc");
    }
}
