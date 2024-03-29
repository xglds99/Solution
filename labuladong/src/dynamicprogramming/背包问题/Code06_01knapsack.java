package dynamicprogramming.背包问题;

import java.util.Scanner;

public class Code06_01knapsack {
    /**
    * @Author xgl
    * @Description 
    * @Date 11:15 2023/4/7
    * @Param [W, N, wt, val]
    * @return int
    **/
    int knapsack(int W, int N, int[] wt, int[] val) {
        assert N == wt.length;
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }
        return dp[N][W];
    }
    /**
     * 空间压缩，将二维空间压缩成一维空间,
     *
     * @param N
     * @param W
     * @param v
     * @param w
     * @return
     */
    int ZeroOneBag(int N, int W, int []v, int []w) {
        int []dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= v[i]; j--) {
                if (j >= v[i]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            }
        }
        return dp[W];
    }

}
