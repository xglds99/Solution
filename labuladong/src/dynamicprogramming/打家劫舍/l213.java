package dynamicprogramming.¥Úº“ΩŸ…·;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/5/4 14:29
 */
public class l213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n + 10];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int mx = dp[1];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            mx = Math.max(mx, dp[i]);
        }
        Arrays.fill(dp, 0);
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        mx = Math.max(mx, dp[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            mx = Math.max(mx, dp[i]);
        }

        return mx;
    }




    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            } else if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }

        public int robRange(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i <= end; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }
}
