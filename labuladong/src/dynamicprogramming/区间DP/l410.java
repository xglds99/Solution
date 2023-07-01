package dynamicprogramming.Çø¼äDP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/29 10:25
 */
public class l410 {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Arrays.fill(dp[n], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], prefixSum[i] - prefixSum[k]));
                }
            }
        }
        return dp[n][m];
    }

}
