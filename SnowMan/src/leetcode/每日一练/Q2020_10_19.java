package leetcode.每日一练;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 * <p>
 */

public class Q2020_10_19 {

    public boolean backspaceCompare(String S, String T) {
        int is = S.length() - 1, it = T.length() - 1;
        while (is > -1 && it > -1) {
            is = check(S, is);
            it = check(T, it);
            if (is == -1) {
                break;
            } else if (it == -1) {
                break;
            } else if (S.charAt(is) != T.charAt(it)) {
                return false;
            }
            is--;
            it--;
        }
        return check(S, is) == check(T, it);
    }

    private int check(String s, int index) {
        int i = index;
        int count = 0;
        while (i > -1 && s.charAt(i) == '#') {
            i--;
            count++;
        }
        while (count > 0) {
            if (i < 0) {
                return -1;
            }
            if (s.charAt(i) == '#') {
                i--;
                count++;
            } else {
                i--;
                count--;
            }
        }
        if (i > -1 && s.charAt(i) == '#') {
            return check(s, i);
        }
        return i;
    }
}
