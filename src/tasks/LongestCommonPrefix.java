package tasks;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int shortestLength = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get().length();

        for(int i = 0; i < shortestLength; i++) {
            char c = strs[0].charAt(i);
            for(int s = 0; s < strs.length; s++) {
                if(c != strs[s].charAt(i)) {
                    return strs[s].substring(0, i);
                }
            }
        }

        return  strs[0].substring(0, shortestLength);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
