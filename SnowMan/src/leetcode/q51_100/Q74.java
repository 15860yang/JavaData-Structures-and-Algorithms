package leetcode.q51_100;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：matrix = [], target = 0
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < target) {
                x = i;
            } else if (matrix[i][0] == target) {
                return true;
            }
        }
        if (x != -1) {
            int startIndex = 0;
            int endIndex = matrix[x].length - 1;
            int[] arr = matrix[x];
            while (startIndex <= endIndex) {
                int i = (endIndex - startIndex) / 2;
                if (i == 0) {
                    return arr[startIndex] == target || arr[endIndex] == target;
                }
                int midIndex = startIndex + i;
                if (arr[midIndex] > target) {
                    if (startIndex == midIndex) {
                        break;
                    }
                    endIndex = midIndex;
                } else if (arr[midIndex] < target) {
                    if (startIndex == midIndex) {
                        break;
                    }
                    startIndex = midIndex;
                } else {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
