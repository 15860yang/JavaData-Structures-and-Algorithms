package leetcode;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int firstSmallerIndex = -1;
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmallerIndex = i;
                break;
            }
        }
        if (firstSmallerIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmallerIndex; i--) {
            if (nums[i] > nums[firstSmallerIndex]) {
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstSmallerIndex, firstLarge);
        reverse(nums, firstSmallerIndex + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
