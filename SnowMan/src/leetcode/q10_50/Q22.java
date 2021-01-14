package leetcode.q10_50;


import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class Q22 {

    public List<String> generateParenthesis(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        getResult(n, 0, 0, stringBuilder, result);
        return result;
    }

    private void getResult(int n, int leftSize, int rightSize, StringBuilder stringBuilder, List<String> result) {
        if (leftSize == n) {
            StringBuilder re = new StringBuilder();
            for (int i = rightSize; i < n; i++) {
                re.append(')');
            }
            result.add(stringBuilder.append(re).toString());
            stringBuilder.delete(stringBuilder.length() - n + rightSize, stringBuilder.length());
        } else {
            getResult(n, leftSize + 1, rightSize, stringBuilder.append('('), result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (rightSize < leftSize) {
                getResult(n, leftSize, rightSize + 1, stringBuilder.append(')'), result);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
