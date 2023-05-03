package dynamicprogramming.子序列问题;

/**
 * @author xgl
 * @date 2023/4/25 14:53
 */
public class l1143 {

    /**
    * @Author xgl
    * @Description 最长公共子序列
    * @Date 16:09 2023/4/25
    * @Param [text1, text2]
    * @return int
    **/
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 10][n + 10];//1.dp[i][j]  代表s1[i]和s2[j]的最长公共子序列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //确定状态转移方程，if s1[i] == s2[j] 序列长度+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果不相等，则选择s1[i]或者s2[j]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
