package dynamicprogramming.��Ʊ����;

/**
* @Author xgl
* @Description
* @Date ����һ���������� prices ������prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
 *
 * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�����ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
 *
 * ���� ���ܻ�õ� ��� ���� 2023/4/24

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
