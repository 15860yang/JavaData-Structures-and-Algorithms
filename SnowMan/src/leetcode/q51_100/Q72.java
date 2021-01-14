package leetcode.q51_100;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Q72 {
    public static int helper(char[] s1, char[] s2, int s1Index, int s2Index, int count) {
        while (s1Index < s1.length && s2Index < s2.length) {
            if (s1[s1Index] != s2[s2Index]) {
                break;
            }
            s1Index++;
            s2Index++;
        }
        if (s1Index == s1.length && s2Index == s2.length) {
            return count;
        } else if (s1Index == s1.length) {

            return count + s2.length - s2Index;
        } else if (s2Index == s2.length) {
            return count + s1.length - s1Index;
        }
        int count1;
        int count2;
        int count3;
        //右边大于左边
        //插入
        count1 = helper(s1, s2, s1Index, s2Index + 1, count + 1);
        //替换
        count2 = helper(s1, s2, s1Index + 1, s2Index + 1, count + 1);
        //删除
        count3 = helper(s1, s2, s1Index + 1, s2Index, count + 1);
        return Math.min(count1, Math.min(count2, count3));
    }

    public int minDistance(String word1, String word2) {
        return helper(word1.toCharArray(), word2.toCharArray(), 0, 0, 0);
    }

    public int minDistance1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


}
