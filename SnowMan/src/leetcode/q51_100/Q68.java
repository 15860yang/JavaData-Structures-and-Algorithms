package leetcode.q51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int nowLen = 0;
        for (String word : words) {
            if ((nowLen + word.length() + temp.size() - 1) >= maxWidth) {
                String str = createCow(temp, nowLen, maxWidth, false);
                nowLen = 0;
                temp.clear();
                res.add(str);
            }
            temp.add(word);
            nowLen += word.length();
        }
        if (temp.size() != 0) {
            String str = createCow(temp, nowLen, maxWidth, true);
            res.add(str);
        }
        return res;
    }

    private String createCow(List<String> temp, int nowLen, int maxWidth, boolean average) {
        if (temp.size() == 1) {
            average = true;
        }
        StringBuilder sb = new StringBuilder();
        int len = maxWidth - nowLen;
        if (average) {
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i != temp.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append(" ".repeat(maxWidth - sb.length()));
        } else {
            int i = len / (temp.size() - 1);
            int j = len % (temp.size() - 1);
            for (int k = 0; k < temp.size(); k++) {
                sb.append(temp.get(k));
                if (k != temp.size() - 1) {
                    sb.append(" ".repeat(i + (j > k ? 1 : 0)));
                }
            }
        }
        return sb.toString();
    }
}
