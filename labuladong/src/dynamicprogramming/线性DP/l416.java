package dynamicprogramming.ÏßÐÔDP;

import java.util.Arrays;

public class l416 {
    public boolean canPartition(int []nums){
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)return false;
        sum /= 2;
        boolean [][]dp = new boolean[n + 10][sum + 10];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum ; j++) {
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
