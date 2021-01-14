package leetcode.q10_50;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * <p>
 */
public class Q42 {
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        return helper(height, maxIndex, 0, true) + helper(height, maxIndex, 0, false);
    }

    private int helper(int[] height, int maxIndex, int res, boolean left) {
        //left
        if (left) {
            if (maxIndex > 0) {
                int secondMaxIndex = maxIndex - 1;
                for (int i = maxIndex - 1; i > -1; i--) {
                    if (height[secondMaxIndex] < height[i]) {
                        secondMaxIndex = i;
                    }
                }
                for (int j = secondMaxIndex + 1; j < maxIndex; j++) {
                    res += height[secondMaxIndex] - height[j];
                }
                res = helper(height, secondMaxIndex, res, true);
            }
        } else {
            if (maxIndex < height.length + 1) {
                int secondMaxIndex = maxIndex + 1;
                for (int i = maxIndex + 1; i < height.length; i++) {
                    if (height[secondMaxIndex] < height[i]) {
                        secondMaxIndex = i;
                    }
                }
                for (int j = maxIndex + 1; j < secondMaxIndex; j++) {
                    res += height[secondMaxIndex] - height[j];
                }
                res = helper(height, secondMaxIndex, res, false);
            }
        }
        return res;
    }
}
