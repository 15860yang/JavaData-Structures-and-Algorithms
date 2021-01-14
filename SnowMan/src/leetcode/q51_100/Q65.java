package leetcode.q51_100;

/**
 * 65. 有效数字
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 */
public class Q65 {
    //小数
    private final int DECIMAL = 0x0001;
    //指数
    private final int INDEX = 0x0002;
    //正数
    private final int POSITIVE_NUMBER = 0x0004;
    //负数
    private final int NEGATIVE_NUMBER = 0x0008;
    //数字开始
    private final int NUMBER_START = 0x0010;
    //数字结束
    private final int NUMBER_END = 0x0020;
    int numberType = 0;

    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (checkType(NUMBER_START)) {
                    setFlag(NUMBER_END);
                } else {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                setFlag(NUMBER_START);
            } else if (c == '.') {
                if (checkType(DECIMAL)) {
                    return false;
                } else {
                    setFlag(DECIMAL);
                }
            } else if (c == 'e') {
                if (checkType(NUMBER_START) && !checkType(INDEX) && !checkType(NUMBER_END)) {
                    setFlag(INDEX);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkType(int flag) {
        return (flag & numberType) == 1;
    }

    void setFlag(int flag) {
        numberType |= flag;
    }


    public boolean isNumber1(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }

            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }

}
