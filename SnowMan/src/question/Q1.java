package question;

/**
 * 问题描述：
 * n个数的数组，请用基于比较的算法以O(N)的时间复杂度求出排序之后相邻数最大的差值
 */
public class Q1 {
    public static int reslove(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int a : arr) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        if (max == min) {
            return 0;
        }
        /**
         * 用两个数组构建出差距数组，最后一趟选出最大数组
         */
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
