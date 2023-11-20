package dynamicprogramming.��������;

public class Code07_allKnapSack {

    /**
    * @Author xgl
    * @Description
    * @Date 14:36 2023/4/25
    * @Param [N, M] N����Ʒ������ΪM
    * @return int
    **/
    int allKnapSack(int N, int M, int[] wt, int[] val){
        int [][]dp = new int[N + 10][M + 10];
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];//������������װ�뱳��
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]); //װ�벻װ������
                }
            }
        }
        return dp[N][M];
    }

    /**
     * �ռ�ѹ��
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
                    dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]); //װ�벻װ������
            }
        }
        return dp[M];
    }
}

