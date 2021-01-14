package leetcode.q10_50;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String src = "1";
        for (int i = 1; i < n; i++) {
            src = once(src.toCharArray());
        }
        return src;
    }


    private String once(char[] src) {
        StringBuilder res = new StringBuilder();

        int count = 1;
        char nowChar = src[0];

        for (int i = 1; i < src.length; i++) {
            if (nowChar != src[i]) {
                res.append(count);
                res.append(nowChar - '0');
                nowChar = src[i];
                count = 1;
            }else {
                count++;
            }
        }
        res.append(count);
        res.append(nowChar - '0');
        return res.toString();
    }
}
