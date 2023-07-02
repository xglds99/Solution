package dynamicprogramming.����������;

/**
 * @author xgl
 * @date 2023/6/25 17:59
 */
public class l115 {
    /**
    * @Author xgl
    * @Description
     * ���������ַ��� s �� t ��ͳ�Ʋ������� s �� ������ �� t ���ֵĸ�����
     * ��Ŀ���ݱ�֤�𰸷��� 32 λ������������Χ��
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
