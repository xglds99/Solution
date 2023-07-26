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
        dp[0][0] = 0;
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
}
//public class test {
//
//    public static void main(String[] args) {
//
//        int[] w= {2,5,4,2,3};
//        int[] v= {6,3,5,4,6};
//        System.out.println(bagkiller(w,v,10));
//    }
//    public static int bagkiller(int[] w,int[] v,int n) {
//        int [][] dp=new int[w.length+1][n+1];
//        for (int i=1;i<=w.length;i++) {
//            for (int j=1;j<=n;j++) {
//                if(j<w[i-1]) //装不下
//                    dp[i][j]=dp[i-1][j]; //就等于i-1件物品容量等于j时候的价值
//                else
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-w[i-1]]+v[i-1]);//装得下分为两种情况1.装 2.不装
//            }
//        }
//        return dp[w.length][n];
//    }
//}
