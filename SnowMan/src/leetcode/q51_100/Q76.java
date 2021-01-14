package leetcode.q51_100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class Q76 {
    public String minWindow1(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, List<Integer>> tempMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
            tempMap.put(c, new LinkedList<>());
        }
        int startIndex = 0;
        int endIndex = 0;
        int tempSize = 0;
        List<Integer> validList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (tempMap.containsKey(s.charAt(i))) {
                validList.add(i);
                tempMap.get(s.charAt(i)).add(i);
                if (tempMap.get(s.charAt(i)).size() <= tMap.get(s.charAt(i))) {
                    tempSize++;
                } else {
                    validList.remove(tempMap.get(s.charAt(i)).get(0));
                    tempMap.get(s.charAt(i)).remove(0);
                }
                if (tempSize == t.length()) {
                    int newStart = validList.get(0);
                    if ((((i + 1) - newStart) < (endIndex - startIndex)) || (endIndex == 0)) {
                        startIndex = validList.get(0);
                        endIndex = i + 1;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex);
    }

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) {
                total--;
            }
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) {
                    total++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

}
