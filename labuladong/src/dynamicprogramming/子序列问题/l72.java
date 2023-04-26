package dynamicprogramming.子序列问题;

/**
 * @author xgl
 * @date 2023/4/25 16:32
 */
public class l72 {

    /**
    * @Author xgl
    * @Description 编辑距离
    * @Date 16:33 2023/4/25
    * @Param [word1, word2]
    * @return int
    **/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 10][n + 10];//1.定义dp数组含义，dp[i][j]代表 s1以i为结尾的字符串 和 s2以j为结尾的字符串的最短编辑距离
        for (int i = 0; i < m; i++) { //2.明确base case 当j = 0的时候，编辑距离需要i + 1
            dp[i + 1][0] = i + 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j + 1] = j + 1;//当i= 0的时候，编辑距离需要j + 1
        }
        //3.明确状态
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //4.确定状态转移方程
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
