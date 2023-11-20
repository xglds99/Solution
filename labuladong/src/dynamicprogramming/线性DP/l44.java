package dynamicprogramming.����DP;

public class l44 {

    /**
     * ����һ�������ַ��� (s) ��һ���ַ�ģʽ (p) ������ʵ��һ��֧�� '?' �� '*' ƥ������ͨ���ƥ�䣺
     * '?' ����ƥ���κε����ַ���
     * '*' ����ƥ�������ַ����У��������ַ����У���
     * �ж�ƥ��ɹ��ĳ�Ҫ�����ǣ��ַ�ģʽ�����ܹ� ��ȫƥ�� �����ַ����������ǲ���ƥ�䣩��i
     *
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        //1.dp���鶨��
        boolean[][] dp = new boolean[m + 1][n + 1];
        //2.��ʼ����ȷ��base case
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
