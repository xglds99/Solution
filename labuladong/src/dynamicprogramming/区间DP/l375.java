package dynamicprogramming.Çø¼äDP;

/**
 * @author xgl
 * @date 2023/4/26 22:03
 */
public class l375 {
    public int getMoneyAmount(int n) {
        int [][] dp = new int[n + 10][n + 10];
        for(int i = n - 1; i >=1; i--){
            for(int j = i + 1; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(i == j) dp[i][j] = 0;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
