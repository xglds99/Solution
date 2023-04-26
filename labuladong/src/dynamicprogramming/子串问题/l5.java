package dynamicprogramming.�Ӵ�����;

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
        //1.ȷ��dp����ĺ��壬dp[i][j]���� s[i -- j]�Ƿ��ǻ����Ӵ�
        boolean[][] dp = new boolean[n + 10][n + 10];
        //����ͨ����̬�滮�ķ�ʽ���Ӵ��Ƿ��ǻ��Ĵ����������
        for (int i = n; i > 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j <= n; j++) {
                //��� cs[i - 1] == cs[j - 1] && (j - i <= 2 || dp[i + 1][j - 1]);
                //����if j - i <= 2��ֻ��Ҫ�ж� ���˵���ĸ�Ƿ���ȼ��ɣ������ж��ڲ���ʣ���Ӵ��Ƿ����
                dp[i][j] = cs[i - 1] == cs[j - 1] && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }
        //������ж� dp[i][j] == true j - i��ֵ��󣬼�Ϊ������Ӵ�
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
