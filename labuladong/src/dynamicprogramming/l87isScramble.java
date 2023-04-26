package dynamicprogramming;

/**
 * @author xgl
 * @date 2023/4/2 10:49
 */
public class l87isScramble {

    static class Solution {
        public boolean isScramble(String s1, String s2) {
            char[] chs1 = s1.toCharArray();
            char[] chs2 = s2.toCharArray();
            int n = s1.length();
            int m = s2.length();
            if (n != m) {
                return false;
            }
            boolean[][][] dp = new boolean[n][n][n + 1];
            // ��ʼ�������ַ������
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][1] = chs1[i] == chs2[j];
                }
            }

            // ö�����䳤�� 2��n
            for (int len = 2; len <= n; len++) {
                // ö�� S �е����λ��
                for (int i = 0; i <= n - len; i++) {
                    // ö�� T �е����λ��
                    for (int j = 0; j <= n - len; j++) {
                        // ö�ٻ���λ��
                        for (int k = 1; k <= len - 1; k++) {
                            // ��һ�������S1 -> T1, S2 -> T2
                            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                            // �ڶ��������S1 -> T2, S2 -> T1
                            // S1 ��� i��T2 ��� j + ǰ���Ƕγ��� len-k ��S2 ��� i + ǰ�泤��k
                            if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
            return dp[0][0][n];
        }
    }
}

