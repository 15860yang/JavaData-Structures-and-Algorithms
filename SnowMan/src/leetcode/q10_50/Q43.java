package leetcode.q10_50;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Q43 {

    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] res = new char[num1.length() + num2.length()];
        char[] temp = new char[num1.length() + num2.length()];
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            res[i] = ('0');
        }
        for (int i = num1.length() - 1; i > -1; i--) {
            int n = num1.charAt(i) - '0';
            int carry = 0;
            for (int t = 0; t < (num1.length() - i - 1); t++) {
                temp[t] = ('0');
            }
            int l = num1.length() - i - 1;
            for (int j = num2.length() - 1; j > -1; j--) {
                int n2 = num2.charAt(j) - '0';
                int res1 = n2 * n + carry;
                temp[l++] = ((char) (res1 % 10 + '0'));
                carry = res1 / 10;
            }
            if (carry != 0) {
                temp[l++] = ((char) (carry + '0'));
            }
            //add
            carry = 0;
            for (int h = 0; h < l; h++) {
                int t2 = res[h] - '0';
                int t1 = temp[h] - '0';
                int r = t1 + t2 + carry;
                res[h] = (char) (r % 10 + '0');
                carry = r / 10;
            }
            if (l < res.length) {
                res[l] += (char) (carry);
            }
        }
        int k = res.length;
        if (res[res.length - 1] == '0') {
            k--;
        }
        return new StringBuilder(new String(res, 0, k)).reverse().toString();
    }
}
