/**
 * 问题描述： 给一个N  表示有一排N个位置， 给一个M 表示初始位置  给一个 P  表示允许走 P 步 ， 给 一个 K  表示需要最终到达的位置
 * <p>
 * 求：如果在0或N-1 位置  那么只能往右或者往左 ，其余位置，既能往左又能往右，求有多少种走法
 */
public class Q15 {

    public static void main(String[] args) {
        System.out.println(Q15.ways(6, 5, 5, 2));
        System.out.println(Q15.ways_dp(6, 5, 5, 2));
    }

    public static int ways(int n, int m, int p, int k) {
        int res = 0;
        if (p == 0) {
            return m == k ? 1 : 0;
        } else {
            if (m == 1) {
                res = ways(n, m + 1, p - 1, k);
            } else if (m == n) {
                res = ways(n, m - 1, p - 1, k);
            } else {
                res = ways(n, m + 1, p - 1, k) + ways(n, m - 1, p - 1, k);
            }
        }
        return res;
    }

    public static int ways_dp(int n, int m, int p, int k) {
        int[][] dp = new int[p + 1][n];
        for (int i = 1; i < n; i++) {
            dp[0][i] = 0;
        }
        dp[0][k - 1] = 1;
        for (int i = 1; i <= p; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][n - 1] = dp[i - 1][n - 2];
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }
        return dp[p][m - 1];
    }
}
