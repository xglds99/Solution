package dynamicprogramming;

public class Code06_01knapsack {

    int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (j < wt[i]) {
                    //�����ǰ����С�ڵ�i����Ʒ�����ѡ�񲻷�
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], //ѡ�񲻷�
                            dp[i - 1][j - wt[i]] + val[i - 1]); //ѡ��Ž�ȥ��i����Ʒ
                }
            }

        }
        return dp[N][W];
    }

}
