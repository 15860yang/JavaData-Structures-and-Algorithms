package leetcode.q10_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Q47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] use = new boolean[nums.length];
        Integer lastUse = null;
        for (int i = 0; i < nums.length; i++) {
            if (lastUse != null && lastUse == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            use[i] = true;
            lastUse = nums[i];
            helper(nums, use, res, temp, i);
            use[i] = false;
            temp.remove(temp.size() - 1);
        }
        return res;
    }

    private void helper(int[] nums, boolean[] use, List<List<Integer>> res, List<Integer> temp, int i) {
        Integer lastUse = null;
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (use[j]) {
                continue;
            }
            if (lastUse != null && lastUse == nums[j]) {
                continue;
            }
            lastUse = nums[j];
            temp.add(nums[j]);
            use[j] = true;
            helper(nums, use, res, temp, j);
            use[j] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
