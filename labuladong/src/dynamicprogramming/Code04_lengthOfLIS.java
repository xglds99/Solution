package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class Code04_lengthOfLIS {
//最长递增子序列
    public  int lengthOfLIS(int []nums){
        int []dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
             ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
