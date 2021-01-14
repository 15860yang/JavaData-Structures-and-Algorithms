package leetcode.q10_50;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 */
public class Q44 {


    //动态规划
    public boolean isMatch(String s, String p) {
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for (int i = 1; i < res.length; i++) {
            res[i][0] = false;
        }
        for (int i = 1; i < res[0].length; i++) {
            char c = p.charAt(i - 1);
            res[0][i] = res[0][i - 1] && c == '*';
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    res[i][j] = res[i - 1][j - 1] || (res[i][j - 1] || res[i - 1][j]);
                } else {
                    res[i][j] = res[i - 1][j - 1] && (c == '?' || c == s.charAt(i - 1));
                }
            }
        }
        return res[s.length()][p.length()];
    }


    /**
     * 普通做法，超时了
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        return helper1(s, p, 0, 0);
    }

    public boolean helper1(String s, String p, int is, int ip) {
        while (is < s.length() && ip < p.length()) {
            char cs = s.charAt(is);
            char cp = p.charAt(ip);
            if (cp == cs || cp == '?') {
                is++;
                ip++;
            } else if (cp == '*') {
                if (ip == p.length() - 1) {
                    return true;
                }
                if (ip + 1 < p.length() && p.charAt(ip + 1) == '*') {
                    ip++;
                    continue;
                }
                return match(s, p, is, ip + 1);
            } else return false;
        }
        return (is == s.length() && ip == p.length()) || (is == s.length() && ppp(p, ip));
    }

    public boolean ppp(String p, int ip) {
        for (int i = ip; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean match(String s, String p, int is, int ip) {
        for (int i = is; i < s.length(); i++) {
            if (helper1(s, p, i, ip)) {
                return true;
            }
        }
        return false;
    }
}

//神的答案
class Solution {
    public boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        return allStars(p, pIndex, pRight);
    }

    public boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }
}