package dynamicprogramming.子串问题;

/**
 * @author xgl
 * @date 2023/4/25 20:02
 */
public class l5 {
    /**
    * @Author xgl
    * @Description
    * @Date 20:02 2023/4/25
    * @Param [s]
    * @return java.lang.String
    **/
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        //1.确定dp数组的含义，dp[i][j]代表 s[i -- j]是否是回文子串
        boolean[][] dp = new boolean[n + 10][n + 10];
        //可以通过动态规划的方式将子串是否是回文串处理出来，
        for (int i = n; i > 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j <= n; j++) {
                //如果 cs[i - 1] == cs[j - 1] && (j - i <= 2 || dp[i + 1][j - 1]);
                //其中if j - i <= 2就只需要判断 两端的字母是否相等即可，不用判断内部的剩余子串是否回文
                dp[i][j] = cs[i - 1] == cs[j - 1] && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }
        //最后在判断 dp[i][j] == true j - i的值最大，即为最长回文子串
        int resi = 0;
        int resj = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] && j - i + 1 >= max) {
                    resi = i;
                    resj = j;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(resi - 1, resj);
    }
}
