package dynamicprogramming.子序列问题;

/**
 * @author xgl
 * @date 2023/4/25 19:17
 */
public class l516 {

    /**
     * @return int
     * @Author xgl
     * @Description 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * @Date 19:17 2023/4/25
     * @Param
     **/
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //1.首先定义dp数组的含义,dp[i][j]代表 s[i --- j]的最长回文子序列的长度
        int[][] dp = new int[n + 10][n + 10];
        char[] chars = s.toCharArray();
        //2.明确base case， s[i -- i]的长度就是1,也是回文序列
        //3.明确状态i，，j的改变，引起状态的改变。
        //4.明确状态转移方程  if s[i] == s[j] dp[i][j] = dp[i + 1][j - 1] + 2 表示这两个可以选
        //if s[i] != s[j] dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) 表示不选s[i]或者s[j]
        //但是因为i的状态由 i + 1的状态转移而来，所以i要倒序遍历
        for (int i = n; i > 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= n; j++) {
                if (chars[i - 1] == chars[j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][n];
    }
}
