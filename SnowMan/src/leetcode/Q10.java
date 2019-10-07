package leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */

public class Q10 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch_1(String s, String p) {
        if (s == null || p == null) return false;
        /**
         * 整个dp二维数组的行变量从0开始到p的各个字符，列变量从0开始到s的各个字符
         * 如：对于s = "aab"  p = "a.*b" 组成的二维数组如下
         *       0  a  .  *  b
         *     0
         *     a
         *     a
         *     b
         */
        /**
         * 这里把p字符串放在行变量上是为了验证p字符串对s的各终结点的子串的匹配情况
         */
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //第一个，0，0点肯定为true
        dp[0][0] = true;
        //先初始化第一行，第一行因为要对空字符串匹配，所以只能由*号做删除才能匹配
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                /**
                 *  ‘*’号可以删除前一个元素，所以查看在不包括前一个元素的情况下，能否匹配。
                 *  这里主要是初始化操作，为了让我们的p字符串匹配到一个空字符串，那么就只能使用'*'去删除他的前一个元素，看看删除之后是不是为空字符串即可
                 */
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        /**
         * 因为前面的初始化都是相当于空字符串操作的，所以这里我们遍历的开始还是从每个字符串的第一个开始。
         */
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i);
            for (int j = 0; j < p.length(); j++) {
                char pC = p.charAt(j);
                if (pC == sC) {
                    /**
                     * 如果此时的p字符串所在字符与s当前位置字符相等，那么p当前位置能否匹配s当前位置取决于p的上一个位置能否匹配s的上个位置
                     */
                    /**
                     * 假设此时 i = 0  j = 0  此时的情况如下：
                     *         0  a  .  *  b
                     *      0  @
                     *      a  F ￥
                     *      a  F
                     *      b  F
                     *
                     *    注：此时 ￥ 处的值取决于 @ 处的值
                     */
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pC == '.') {
                    /**
                     * 如果此时 p 字符串当前字符是'.'，因为'.'的效果是可以替换任意字符，所以也可以类比到-》此时字符与s当前字符相等，故结果同上
                     */
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pC == '*') {
                    /**
                     * 如果此时p字符串当前位置是'*'，因为'*'的效果是可以把上个字符复制-1到n次，换而言之，'*'既可以把上个字符删掉，
                     * 也可以在上个字符后面再复制任意个上个字符。
                     *
                     * 这里我们要根据三种情况进行讨论，也就是p字符串的'*'之前的字符，要么与s当前位置的字符相等，要么不相等，要么为'.'
                     *
                     * 所以分以下三种情况进行判断：
                     */
                    if (p.charAt(j - 1) == sC) {
                        /**
                         * p的上个位置与s的当前位置相等，如下：
                         *      图示如下：假设此时 i = 1  j = 1
                         *         0  a  *  .  b
                         *      0  T
                         *      a  F  #
                         *      a  %  @  $
                         *      b  F
                         *  此时p位置'*'，p的上一位置为'a'，s 位置'a'
                         *
                         * 所以此时当以下三种情况时，$为true ：
                         *     1，@为true
                         *     2，#为true
                         *     3，%为true
                         */
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j];
                    } else if (p.charAt(j - 1) == '.') {
                        /**
                         * p的上个位置与为'.'，如下：
                         *      图示如下：假设此时 i = 1  j = 2
                         *         0  a  .  *  b
                         *      0  T  &
                         *      a  F        %
                         *      a  F  #  @  $
                         *      b  F
                         *  此时p位置'*'，p的上一位置为'.'，s 位置'a'
                         *
                         * 所以此时当以下四种情况时，$为true ：
                         *     1，@为true
                         *     2，#为true
                         *     3，%为true，这里的原因是因为前面为'.',而'*'的作用是复制前一个字符任意次，所以这里直接再复制两个'.'即可
                         *     4，当满足&位置存在时，&为true也满足条件
                         */
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1];
                        if (i >= 1) {
                            dp[i + 1][j + 1] |= dp[i - 1][j - 1];
                        }
                    } else {
                        /**
                         * p的上个位置既不为'.'也不与s的上个位置相等，如下：
                         *      图示如下：假设此时 i = 1  j = 1
                         *         0  a  c  *  b
                         *      0  T
                         *      a  F
                         *      a  F  #     $
                         *      b  F
                         *  所以此时可能匹配的情况就是'*'将前一个字符删掉，只要#位置匹配了，$也就为true了
                         */
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
