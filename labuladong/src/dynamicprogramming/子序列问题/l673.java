package dynamicprogramming.子序列问题;

public class l673 {
    /**
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     * <p>
     * 注意 这个数列必须是 严格 递增的。
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int res = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (nums[j] + 1 > nums[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; //重置最长子序列出现次数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = cnt[i];
            } else if (dp[i] == maxLen) {
                res += cnt[i];
            }

        }
        return res;
    }
}
