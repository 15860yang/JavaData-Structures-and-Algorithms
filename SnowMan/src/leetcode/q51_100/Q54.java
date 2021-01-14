package leetcode.q51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
        for (int i = 0; i < (matrix.length + 1) / 2 && i < (matrix[0].length + 1) / 2; i++) {
            int x = i;
            int y = i;
            boolean toBottom = false;
            boolean toRight = false;
            res.add(matrix[x][y]);
            while (++y < matrix[0].length - i) {
                toRight = true;
                res.add(matrix[x][y]);
            }
            y--;
            while (++x < matrix.length - i) {
                toBottom = true;
                res.add(matrix[x][y]);
            }
            x--;
            if (toRight && toBottom) {
                while (--y > i - 1) {
                    res.add(matrix[x][y]);
                }
                y++;
            }
            if (toRight && toBottom) {
                while (--x > i) {
                    res.add(matrix[x][y]);
                }
            }
        }
        return res;
    }
}
