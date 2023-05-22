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




    /**�������㷨
    * @Author xgl
    * @Description
    * @Date 20:56 2023/5/20
    * @Param [s]
    * @return java.lang.String
    **/
    public static String Manacher(String s) {
        if (s.length() < 2) {
            return s;
        }
        // ��һ����Ԥ������ԭ�ַ���ת��Ϊ���ַ���
        StringBuilder t = new StringBuilder("$");
        for (int i=0; i<s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        // β���ټ����ַ�@����Ϊ���������ַ���
        t.append("#@");
        // �ڶ�������������p����ʼ����������İ뾶
        int n = t.length();
        // p����
        int[] p = new int[n];
        int id = 0, mx = 0;
        // ������Ӵ��ĳ���
        int maxLength = -1;
        // ������Ӵ�������λ������
        int index = 0;
        for (int j=1; j<n-1; j++) {
            // �ο�ǰ�ĵ��岿��
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // �������������죬��չ�ұ߽�
            while (t.charAt(j+p[j]) == t.charAt(j-p[j])) {
                p[j]++;
            }
            // ��������Ӵ����ұ߽糬����mx������Ҫ����mx��id��ֵ
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // ��������Ӵ��ĳ��ȴ���maxLength�������maxLength��index��ֵ
            if (maxLength < p[j] - 1) {
                // �ο�ǰ�ĵ�������
                maxLength = p[j] - 1;
                index = j;
            }
        }
        // ����������ȡ�ַ�����������
        // ��ʼ�����ļ���ο�ǰ�ĵ��Ĳ���
        int start = (index-maxLength)/2;
        return s.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        System.out.println(l5.Manacher("123456654321dsadasdasi9uhf8923h89fewfgjisjhiu9dhguasasasasasasasasasasasasasasasasasa"));
    }
}
