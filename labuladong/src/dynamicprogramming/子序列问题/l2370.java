package dynamicprogramming.子序列问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName l2370
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 15:18
 * @Version 1.0
 */
public class l2370 {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int [][]dp = new int[n + 10][26]; //s的前i个字符中，以[a..z]为结尾的最长理想子序列的长度
        for (int i = 1; i <=  n; i++) {
            int c = cs[i - 1] - 'a';
            System.arraycopy(dp[i - 1], 0, dp[i], 0, 26);
            for (int j = Math.max(0,c-k); j <= Math.min(25,c+k) ; j++) {
                dp[i][c] = Math.max(dp[i][c], dp[i - 1][j] + 1);
            }
        }
        return Arrays.stream(dp[n]).max().getAsInt();
    }

    static class Solution {
        public int longestIdealString(String s, int k) {
            var f = new int[26];
            for (var i = 0; i < s.length(); i++) {
                var c = s.charAt(i) - 'a';
                for (var j = Math.max(c - k, 0); j <= Math.min(c + k, 25); j++)
                    f[c] = Math.max(f[c], f[j]);
                f[c]++;
            }
            return Arrays.stream(f).max().getAsInt();
        }
    }


}
