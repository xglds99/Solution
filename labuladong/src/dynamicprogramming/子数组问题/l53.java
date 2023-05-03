package dynamicprogramming.子数组问题;

/**
 * @author xgl
 * @date 2023/5/2 21:44
 */
public class l53 {
    public int maxSubArray( int[] nums) {
        int n = nums.length;
        int []dp = new int[n + 1]; //dp[i]代表 以i为结尾的最大子数组和
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
       return res;
    }
}
