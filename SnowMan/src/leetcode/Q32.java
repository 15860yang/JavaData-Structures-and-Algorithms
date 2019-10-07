package leetcode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

public class Q32 {
    //栈方法
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int start = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - start);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }

    //dp
    public int longestValidParentheses_1(String s) {
        int maxLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? 2 + dp[i - 2] : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }

    //前后分别扫描
    public int longestValidParentheses_2(String s) {
        int maxLength = 0;
        int leftSize = 0;
        int rightSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftSize++;
            } else {
                rightSize++;
                if (rightSize == leftSize) {
                    maxLength = Math.max(maxLength, 2 * rightSize);
                } else if (rightSize > leftSize) {
                    rightSize = 0;
                    leftSize = 0;
                }
            }
        }
        rightSize = 0;
        leftSize = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '(') {
                leftSize++;
                if (leftSize == rightSize) {
                    maxLength = Math.max(maxLength, 2 * leftSize);
                } else if (leftSize > rightSize) {
                    rightSize = 0;
                    leftSize = 0;
                }
            } else {
                rightSize++;
            }
        }
        return maxLength;
    }


}
