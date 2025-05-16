package M_java_programs;

import java.util.HashMap;
import java.util.Map;

//        "aabbcdd" → 'c'
//        "aabbcc" → '-'
//        "teeterrace" → 'a'
public class FirstNonRepeatingChar {
    static char firstNonRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return '-';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("teeterrace"));
    }
}
