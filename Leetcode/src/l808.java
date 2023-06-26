/**
 * @author xgl
 * @date 2023/6/25 18:44
 */
public class l808 {
    public double soupServings(int n) {
        n = (int)Math.ceil((double)n / 25);
        if (n >= 179) return 1.0;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n ; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {

            }
        }
        return 0;
    }
}
