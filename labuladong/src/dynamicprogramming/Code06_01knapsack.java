package dynamicprogramming;

public class Code06_01knapsack {

    int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (j < wt[i]) {
                    //如果当前容量小于第i个物品体积，选择不放
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], //选择不放
                            dp[i - 1][j - wt[i]] + val[i - 1]); //选择放进去第i个物品
                }
            }

        }
        return dp[N][W];
    }

}
