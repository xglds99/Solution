package dynamicprogramming.����������;

/**
 * @author xgl
 * @date 2023/4/25 14:53
 */
public class l1143 {

    /**
    * @Author xgl
    * @Description �����������
    * @Date 16:09 2023/4/25
    * @Param [text1, text2]
    * @return int
    **/
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
