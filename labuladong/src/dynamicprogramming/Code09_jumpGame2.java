package dynamicprogramming;

import java.util.Arrays;

public class Code09_jumpGame2 {

    int memo[];
    public int jump(int []nums){
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    /**
     * dp函数定义，从i出发跳到最后一格，至少需要dp(nums, i)步。
     * @param nums
     * @param i
     * @return
     */
    private int dp(int[] nums, int i) {
        int n = nums.length;
        if (i >= n - 1)return 0;
        if (memo[i] != n)return memo[i];
        int steps = nums[i];
        for (int j = 1; j <= steps ; j++) {
            int subProblem = dp(nums, i + j);
            memo[i] = Math.min(memo[i], subProblem + 1);
        }
        return memo[i];
    }


}
