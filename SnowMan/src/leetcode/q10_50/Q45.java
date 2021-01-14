package leetcode.q10_50;

import javax.swing.plaf.IconUIResource;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Q45 {

    /**
     * 一步一步往前跳，始终有一个最大距离在约束，最大距离之内，如果还能跳到更远，那肯定要更新，但是步数只能算一步，在下一次到达最大位置的时候
     * 再去更新步数，因为此时必须往前跳了。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int maxNext = 0;
        int curMaxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxNext) {
                curMaxNext = maxNext;
                res++;
            }
        }
        return res;
    }

    /**
     * 还有一种算法是，在当前能跳到的最大距离上蹦跶，看看最远能蹦跶到哪，能蹦跶多远，那就能跳到多远，
     */
}
