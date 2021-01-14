package leetcode.q10_50;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 */

/**
 *
 * 主要思路是，先排序，递归求解，相同的数字对后面的影响只能出现一次，且相同的数字对结果相同的数字也只能影响一次
 * 上面两个主要是为了排除重复
 *
 *
 */
public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> processList = new ArrayList<>();
        helper(candidates, res, processList, target, 0, false);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> processList, int target, int index, boolean isAdd) {
        if (target == 0 && processList.size() != 0) {
            res.add(new ArrayList<>(processList));
        }
        if (index == candidates.length || target < 0 || target < candidates[index]) {
            return;
        }
        helper(candidates, res, processList, target, index + 1, false);
        //这句主要排除相同的相同的对后续的干扰
        if (index > 0 && candidates[index] == candidates[index - 1]
                && (processList.size() == 0 || candidates[index] != processList.get(processList.size() - 1))) {
            return;
        }
        //这句排除相同的对结果相同的干扰,isAdd参数主要为了避免两个相同的值在不同位置的出现对相同结果的干扰
        if (!isAdd && processList.size() > 0 && candidates[index] == processList.get(processList.size() - 1)
                && index > 1 && target - candidates[index] == target - candidates[index - 1]) {
            return;
        }
        processList.add(candidates[index]);
        helper(candidates, res, processList, target - candidates[index], index + 1, true);
        processList.remove(processList.size() - 1);
    }
}

























