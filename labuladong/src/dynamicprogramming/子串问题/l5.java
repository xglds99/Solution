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




    /**马拉车算法
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
        // 第一步：预处理，将原字符串转换为新字符串
        StringBuilder t = new StringBuilder("$");
        for (int i=0; i<s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        // 尾部再加上字符@，变为奇数长度字符串
        t.append("#@");
        // 第二步：计算数组p、起始索引、最长回文半径
        int n = t.length();
        // p数组
        int[] p = new int[n];
        int id = 0, mx = 0;
        // 最长回文子串的长度
        int maxLength = -1;
        // 最长回文子串的中心位置索引
        int index = 0;
        for (int j=1; j<n-1; j++) {
            // 参看前文第五部分
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // 向左右两边延伸，扩展右边界
            while (t.charAt(j+p[j]) == t.charAt(j-p[j])) {
                p[j]++;
            }
            // 如果回文子串的右边界超过了mx，则需要更新mx和id的值
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
            if (maxLength < p[j] - 1) {
                // 参看前文第三部分
                maxLength = p[j] - 1;
                index = j;
            }
        }
        // 第三步：截取字符串，输出结果
        // 起始索引的计算参看前文第四部分
        int start = (index-maxLength)/2;
        return s.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        System.out.println(l5.Manacher("123456654321dsadasdasi9uhf8923h89fewfgjisjhiu9dhguasasasasasasasasasasasasasasasasasa"));
    }
}
