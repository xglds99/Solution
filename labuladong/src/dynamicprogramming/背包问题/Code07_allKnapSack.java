package dynamicprogramming.背包问题;

public class Code07_allKnapSack {

    /**
    * @Author xgl
    * @Description
    * @Date 14:36 2023/4/25
    * @Param [N, M] N个物品，容量为M
    * @return int
    **/
    int allKnapSack(int N, int M, int[] wt, int[] val){
        int [][]dp = new int[N + 10][M + 10];
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];//容量不够，不装入背包
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]); //装与不装，择优
                }
            }
        }
        return dp[N][M];
    }

    /**
     * 空间压缩
     * @param N
     * @param M
     * @param wt
     * @param val
     * @return
     */
    int AllBAG(int N, int M, int[] wt, int[] val){
        int []dp = new int[M + 10];
        for(int i = 1; i <= N; i++) {
            for (int j = wt[i - 1]; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]); //装与不装，择优
            }
        }
        return dp[M];
    }
}

