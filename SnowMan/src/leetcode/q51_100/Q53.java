package leetcode.q51_100;

/**
 * 最大子序和
 */
public class Q53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int num : nums) {
            cur = Math.max(cur + num, num);
            max = Math.max(max, cur);
        }
        return max;
    }
}
