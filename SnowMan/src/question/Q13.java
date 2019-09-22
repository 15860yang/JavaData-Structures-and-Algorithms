package question;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述：假设当前有  2  5  10  20  50  这些个面值的货币，求可以组成100元的方法，每种面值货币的数量不做限制
 * 所以： 问题：有一个基础数组，求使用这个基础数组可以组成给定数字 aim 时  有多少中不同的方法
 */
public class Q13 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        int i = 0;
        for (int a = 0; a < 100; a++) {
            i = Q13.Solution_dp(new int[]{5, 3, 2}, 1011);
        }
        long t = System.currentTimeMillis();
        System.out.println(t - time);
        System.out.println(i + "次");
    }


    public static int Solution_baoli(int[] arr, int aim) {
        return getCount(arr, 0, aim);
    }

    private static int getCount(int[] arr, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; arr[index] * i <= aim; i++) {
            res += getCount(arr, index + 1, aim - arr[index] * i);
        }
        return res;
    }

    public static int Solution_01(int[] arr, int aim) {
        HashMap<String, Integer> cache = new HashMap<>();
        return getCount(arr, cache, 0, aim);
    }

    private static int getCount(int[] arr, Map<String, Integer> cache, int index, int aim) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        int t = 0;
        for (int i = 0; arr[index] * i <= aim; i++) {
            if (cache.containsKey(index + "_" + aim)) {
                res += cache.get(index + "_" + aim);
            } else {
                res += getCount(arr, index + 1, aim - arr[index] * i);
            }
        }
        cache.put(index + "_" + aim, res);
        return res;
    }
    //动态规划画表格做
    public static int Solution_dp(int[] arr, int aim) {
        int dp[][] = new int[arr.length + 1][aim + 1];
        for (int i = 1; i < aim; i++) {
            dp[arr.length][i] = 0;
        }
        for (int i = arr.length; i >= 0; i--) {
            dp[i][0] = 1;
        }
        int num = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j < aim + 1; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i+1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[0][aim];
    }

}
