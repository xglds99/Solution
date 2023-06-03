package dynamicprogramming.打家劫舍;

/**
 * @author xgl
 * @date 2023/5/4 14:28
 */
public class l198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];//dp[i]偷到以i为最后一个最大价值
        int mx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            mx = Math.max(mx, dp[i]);
        }
        return mx;
    }


    public int rob_1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 10];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

}
