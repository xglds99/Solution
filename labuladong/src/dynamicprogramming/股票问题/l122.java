package dynamicprogramming.股票问题;

/**
* @Author xgl
* @Description
* @Date 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。 2023/4/24

 * @author xgl
 * @date 2023/4/24 21:42
 */
public class l122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n + 10][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit_1(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n + 10][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n][0];
    }
}
