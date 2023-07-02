package dynamicprogramming.ÏßÐÔDP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/5/29 16:24
 */
public class l313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        long []dp = new long[n + 1];
        int []pointers = new int[m];
        long[]num = new long[m];
        Arrays.fill(num, 1);
        for (int i = 1; i <= n; i++) {
            long minVal = Arrays.stream(num).min().getAsLong();
            dp[i] = minVal;
            for (int j = 0; j < m; j++) {
                if (num[j] == minVal){
                    pointers[j]++;
                    num[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return (int) dp[n];
    }
}
