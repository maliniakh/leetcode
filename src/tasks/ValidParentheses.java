package tasks;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                char stackC = stack.pop();

                if(c == ')' && stackC != '(') {
                    return false;
                } else if(c == ']' && stackC != '[') {
                    return false;
                } else if(c == '}' && stackC != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
