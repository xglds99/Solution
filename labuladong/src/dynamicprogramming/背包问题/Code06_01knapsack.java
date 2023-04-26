package dynamicprogramming.��������;

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
        // base case �ѳ�ʼ��
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // ���������ֻ��ѡ��װ�뱳��
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // װ����߲�װ�뱳��������
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }
        return dp[N][W];
    }

}
