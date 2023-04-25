package dynamicprogramming.π…∆±Œ Ã‚;

/**
 * @author xgl
 * @date 2023/4/24 21:36
 */
public class l121 {

    public int maxProfit(int []prices){
        int n = prices.length;
        int [] dp = new int[n + 10];
        dp[0] = 0;
        int minPrice = prices[0];
        for(int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[n];
    }
}
