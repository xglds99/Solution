package dynamicprogramming.π…∆±Œ Ã‚;

/**
 * @author xgl
 * @date 2023/4/24 21:54
 */
public class l309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n + 10][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n][0];
    }
}
