package dynamicprogramming.状压DP;

import java.util.Arrays;

public class l2741 {
    private int MOD = (int) 1e9 + 7;
    private int memo[][];

    public int specialPerm(int[] nums) {
        int n = nums.length;
        memo = new int[1 << n][n + 5];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res  = (res + dfs(nums,((1 << n) - 1) ^ (1 << i), i) % MOD) %MOD;
        }
        return res;
    }

    /**
     * @param i 表示还剩多少元素可以选
     * @param j 表示上一次选了那个元素
     * @return
     */
    public int dfs(int[] nums, int i, int j) {
        if (i == 0) return 1;
        if (memo[i][j] != -1)return memo[i][j];
        int res = 0;
        for (int k = 0; k < nums.length; k++) {
            if ((i >> k & 1) == 1 && nums[k] % nums[j] == 0 || nums[j] % nums[k] == 0){
                res = (res +  dfs(nums, i ^ (1 << k) ,k)) % MOD;
            }
        }
        return memo[i][j] = res;
    }


    public int specialPermdp(int[] nums) {
        int n = nums.length;
        int res = 0;
        int [][]dp = new int[1 << n][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ( ((i << k) & 1) == 1  && (nums[k] % nums[j] == 0 || nums[j] % nums[k] == 0)){
                        dp[i][j] = (dp[i][j] + dp[i ^ (1 << k)][k]) % MOD;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            res = (res + dp[((1 << n) - 1) ^ (1 << i)][i]) % MOD;
        }
        return res;
    }

    class Solution {
        private static final int MOD = (int) 1e9 + 7;
        public int specialPerm(int[] nums) {
            var n = nums.length;
            var f = new int[1 << n][n];
            Arrays.fill(f[0], 1);
            for (int i = 0; i < 1 << n; ++ i) {
                for (int j = 0; j < n; ++ j) {
                    for (int k = 0; k < n; ++ k) {
                        if (((i >> k) & 1) == 1 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)) {
                            f[i][j] = (f[i][j] + f[i ^ (1 << k)][k]) % MOD;
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; ++ i) ans = (ans + f[((1 << n) - 1) ^ (1 << i)][i]) % MOD;
            return ans;
        }
    }
}
