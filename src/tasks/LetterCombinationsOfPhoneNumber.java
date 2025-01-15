package tasks;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    static public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, String> buttonMap = new HashMap<>();
        buttonMap.put('2', "abc");
        buttonMap.put('3', "def");
        buttonMap.put('4', "ghi");
        buttonMap.put('5', "jkl");
        buttonMap.put('6', "mno");
        buttonMap.put('7', "pqrs");
        buttonMap.put('8', "tuv");
        buttonMap.put('9', "wxyz");

        Stack<String> stack = new Stack<>();
        stack.push("");
        List<String> result = new ArrayList<>();

        while(!stack.isEmpty()) {
            String current = stack.pop();

            if (current.length() == digits.length()) {
                result.add(current);
                continue;
            }

            Character number = digits.charAt(current.length());
            String letters = buttonMap.get(number);

            for (int i = letters.length() - 1; i >= 0; i--) {
                char c = letters.charAt(i);
                stack.push(current + c);
//                if(!current.contains(Character.toString(c))) {
//                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("235");
        System.out.println(strings);
    }
}
