package leetcode;

import java.util.Stack;

public class Q20 {

    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char cc : s.toCharArray()) {
            switch (cc) {
                case '(':
                    stack.push(1);
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != 1)
                        return false;
                    break;
                case '{':
                    stack.push(2);
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != 2)
                        return false;
                    break;
                case '[':
                    stack.push(3);
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != 3)
                        return false;
                    break;
            }
        }
        return stack.size() == 0;
    }

}
