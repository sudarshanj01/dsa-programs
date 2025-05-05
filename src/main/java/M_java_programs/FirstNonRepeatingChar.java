package M_java_programs;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    static char firstNonRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) return entry.getKey();
        }

        return '-';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("teeterrace"));
    }
}
