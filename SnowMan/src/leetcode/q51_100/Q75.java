package leetcode.q51_100;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class Q75 {
    public void sortColors(int[] arr) {
        /**
         * 1之前的index
         */
        int whiteBefore = -1;
        /**
         * 1之后的index
         */
        int whiteAfter = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[++whiteBefore] = 0;
                if (whiteAfter == -1) {
                    whiteAfter = whiteBefore;
                }
                if (whiteAfter > whiteBefore) {
                    arr[++whiteAfter] = 1;
                }
                if (whiteAfter < i) {
                    arr[i] = 2;
                }
            } else if (arr[i] == 1) {
                arr[++whiteAfter] = 1;
                if (whiteAfter < i) {
                    arr[i] = 2;
                }
            }
        }
    }

    public void sortColors1(int[] arr) {
        int one_start = -1;
        int one_end = arr.length;
        for (int i = 0; i < one_end; i++) {
            if (arr[i] == 0) {
                one_start++;
                if (one_start < i) {
                    arr[i] = arr[one_start];
                    i--;
                }
                arr[one_start] = 0;
            } else if (arr[i] == 2) {
                one_end--;
                arr[i] = arr[one_end];
                arr[one_end] = 2;
                i--;
            }
        }
    }
}
