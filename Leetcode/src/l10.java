/**
 * @author xgl
 * @date 2023/5/8 9:31
 */
public class l10 {

    public boolean isMatch(String a, String p) {
        int m = a.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1]; //定义dp数组,dp[i][j]表示a前i个字符到p前j个字符是否可以匹配
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(a, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(a, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }


    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
