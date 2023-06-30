package dynamicprogramming.ÏßÐÔDP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/5/29 16:24
 */
public class l313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        int m = primes.length;
        int []pointers = new int[m];
        int []num = new int[m];
        for (int i = 1; i <= n; i++) {
            int minVal = Arrays.stream(num).min().getAsInt();
            dp[i] = minVal;
            for (int j = 0; j < m; j++) {
                if (minVal == num[j]){
                    pointers[j]++;
                    num[j] = dp[pointers[j]] * primes[j];
                }
            }
        }
        return dp[n];
    }
}
