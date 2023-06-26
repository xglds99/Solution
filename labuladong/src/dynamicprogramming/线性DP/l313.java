package dynamicprogramming.ÏßÐÔDP;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

/**
 * @author xgl
 * @date 2023/5/29 16:24
 */
public class l313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int p = primes.length;
        int []pointers = new int[p];
        int []curValues = new int[p];
        int []dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int mn = Integer.MAX_VALUE;
            for (int j = 0; j < p; j++) {
                 curValues[j] = dp[pointers[j]] * primes[j];
                if (curValues[j] < 0) {
                }
                else mn = Math.min(curValues[j], mn);
            }
            dp[i] = mn;
            for (int j = 0; j < p; j++) {
                if (curValues[j] == mn) pointers[j]++;
            }
        }
        return dp[n - 1];
    }
}
