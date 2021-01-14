package leetcode.q51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * <p>
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 * <p>
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 * <p>
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */
public class Q71 {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        List<Character> cs = new ArrayList<>();
        boolean maybe = false;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.') {
                if (!maybe) {
                    maybe = true;
                } else {
                    if (cs.size() > 0) {
                        cs.remove(cs.size() - 1);
                    }
                    while (cs.size() > 0 && cs.get(cs.size() - 1) != '/') {
                        cs.remove(cs.size() - 1);
                    }
                    maybe = false;
                }
            } else {
                maybe = false;
                if (path.charAt(i) == '/') {
                    if (cs.size() == 0 || cs.get(cs.size() - 1) != '/') {
                        cs.add('/');
                    }
                } else {
                    cs.add(path.charAt(i));
                }
            }
        }
        for (Character c : cs) {
            res.append(c);
        }
        if (res.length() > 1 && res.charAt(res.length() - 1) == '/') {
            res.deleteCharAt(res.length() - 1);
        } else if (res.length() == 0) {
            res.append('/');
        }
        return res.toString();
    }

    public String simplifyPath1(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
