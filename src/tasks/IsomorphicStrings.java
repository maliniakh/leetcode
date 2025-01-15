package tasks;

import kotlin.Pair;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    static public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            Character mappedChar = mapping.get(sc);
            if(mappedChar == null) {
                if(mapping.containsValue(tc)) {
                    return false;
                }

                mapping.put(sc, tc);
            } else {
                if(mappedChar != tc) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result = isIsomorphic("badc", "baba");
    }
}
