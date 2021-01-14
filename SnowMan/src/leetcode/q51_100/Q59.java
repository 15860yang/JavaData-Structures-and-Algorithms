package leetcode.q51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[(int) Math.sqrt(n)][(int) Math.sqrt(n)];
        int index = 1;
        for (int i = 0; i < (res.length + 1) / 2 && i < (res[0].length + 1) / 2; i++) {
            int x = i;
            int y = i;
            boolean toBottom = false;
            boolean toRight = false;
            res[x][y] = index++;
            while (++y < res[0].length - i) {
                toRight = true;
                res[x][y] = index++;
            }
            y--;
            while (++x < res.length - i) {
                toBottom = true;
                res[x][y] = index++;
            }
            x--;
            if (toRight && toBottom) {
                while (--y > i - 1) {
                    res[x][y] = index++;
                }
                y++;
            }
            if (toRight && toBottom) {
                while (--x > i) {
                    res[x][y] = index++;
                }
            }
        }
        return res;
    }
}
