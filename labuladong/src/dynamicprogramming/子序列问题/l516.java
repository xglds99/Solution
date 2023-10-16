package dynamicprogramming.����������;

/**
 * @author xgl
 * @date 2023/4/25 19:17
 */
public class l516 {

    /**
     * @return int
     * @Author xgl
     * @Description ����һ���ַ��� s ���ҳ�������Ļ��������У������ظ����еĳ���
     * �����ж���Ϊ�����ı�ʣ���ַ�˳�������£�ɾ��ĳЩ�ַ����߲�ɾ���κ��ַ��γɵ�һ�����С�
     * @Date 19:17 2023/4/25
     * @Param
     **/
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //1.���ȶ���dp����ĺ���,dp[i][j]���� s[i --- j]������������еĳ���
        int[][] dp = new int[n + 10][n + 10];
        char[] chars = s.toCharArray();
        //2.��ȷbase case�� s[i -- i]�ĳ��Ⱦ���1,Ҳ�ǻ�������
        //3.��ȷ״̬i����j�ĸı䣬����״̬�ĸı䡣
        //4.��ȷ״̬ת�Ʒ���  if s[i] == s[j] dp[i][j] = dp[i + 1][j - 1] + 2 ��ʾ����������ѡ
        //if s[i] != s[j] dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) ��ʾ��ѡs[i]����s[j]
        //������Ϊi��״̬�� i + 1��״̬ת�ƶ���������iҪ�������
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
