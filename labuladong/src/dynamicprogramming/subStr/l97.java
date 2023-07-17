package dynamicprogramming.subStr;

/**
 * @ClassName l97
 * @Description
 * @Author xgl
 * @Date 2023/7/17 11:48
 * @Version 1.0
 */
public class l97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int maxValue = Integer.MAX_VALUE;

        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n != t)return false;
        //f(i,j) 表示 s1
        //  的前 i个元素和 s2
        //  的前 j 个元素是否能交错组成 s3
        //  的前 i+j个元素
        boolean [][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= m; j++) {
                int p = i + j - 1;
                if (i > 0)dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                if (j > 0)dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return dp[m][n];
    }
}
