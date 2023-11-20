package dynamicprogramming.线性DP;

public class l44 {

    /**
     * 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符序列（包括空字符序列）。
     * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。i
     *
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        //1.dp数组定义
        boolean[][] dp = new boolean[m + 1][n + 1];
        //2.初始化，确定base case
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*')dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == '?' || s.charAt(j - 1) == p.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
