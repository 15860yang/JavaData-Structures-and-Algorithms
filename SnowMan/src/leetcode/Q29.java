package leetcode;

public class Q29 {

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if (lDividend < lDivisor || lDividend == 0) return 0;
        long lres = divide(lDividend, lDivisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE) {
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else res = (int) (sign * lres);
        return res;
    }

    private long divide(long lDividend, long lDivisor) {
        if (lDividend < lDivisor) return 0;
        long sum = lDivisor;
        long multiple = 0;
        int mul = 1;

        while (lDividend >= lDivisor) {
            if (lDividend > sum + sum) {
                lDividend -= sum + sum;
                multiple += mul + mul;
                mul += mul;
                sum += sum;
            } else {
                sum = lDivisor;
                mul = 1;
                lDividend -= sum;
                multiple += mul;
            }
        }
        return multiple;
    }

}
