package dynamicprogramming.子序列问题;

/**
 * @author xgl
 * @date 2023/6/25 17:59
 */
public class l115 {
    /**
    * @Author xgl
    * @Description
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
     * 题目数据保证答案符合 32 位带符号整数范围。
     *
    * @Date 17:59 2023/6/25
    * @Param [s, t]
    * @return int
    **/
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
