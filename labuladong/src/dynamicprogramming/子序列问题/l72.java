package dynamicprogramming.����������;

/**
 * @author xgl
 * @date 2023/4/25 16:32
 */
public class l72 {

    /**
    * @Author xgl
    * @Description �༭����
    * @Date 16:33 2023/4/25
    * @Param [word1, word2]
    * @return int
    **/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 10][n + 10];//1.����dp���麬�壬dp[i][j]���� s1��iΪ��β���ַ��� �� s2��jΪ��β���ַ�������̱༭����
        for (int i = 0; i < m; i++) { //2.��ȷbase case ��j = 0��ʱ�򣬱༭������Ҫi + 1
            dp[i + 1][0] = i + 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j + 1] = j + 1;//��i= 0��ʱ�򣬱༭������Ҫj + 1
        }
        //3.��ȷ״̬
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //4.ȷ��״̬ת�Ʒ���
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
