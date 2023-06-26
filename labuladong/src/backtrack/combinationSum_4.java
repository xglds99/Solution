package backtrack;

import java.util.Arrays;

public class combinationSum_4 {
    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     *
     * 题目数据保证答案符合 32 位整数范围。
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * @param nums
     * @param target
     * @return
     */

    private int memo[];
    public  int combinationSum4(int []nums, int target){
        memo = new int[target + 1];
        Arrays.fill(memo, -100001);
        memo[0] = 1;
        int res = dfs(nums,target);
        return res;
    }


    public  int combinationSum4dp(int []nums, int target){
        int n = nums.length;
        int []dp = new  int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int k = 0;
            for (int num : nums) {
                if (i - num < 0) continue;
                k += dp[i - num];
            }
            dp[i] = Math.max(dp[i], k);
        }
        return dp[target];
    }
    /**
     * dfs函数定义 求出目标和为target的组合个数
     * @param nums
     * @param target
     * @return
     */
    public  int dfs(int []nums, int target){
        int res = 0;
       if (memo[target] != -10001) return memo[target];
       if (target == 0)return 1;
       for (int num: nums){
           if (target - num < 0) continue;
           res += dfs(nums, target - num);
       }
       memo[target] = res;
        return res;
    }


}
