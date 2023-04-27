package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xgl
 * @date 2023/4/27 16:31
 */
public class l1048 {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int []dp = new int[n + 10]; //dp[i]代表 前i个元素中最长词链长度
        Arrays.fill(dp, 1);
        for(int i = 2; i<= n; i++){
            if(help(words[i - 2], words[i - 1])){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        return dp[n];
    }
    public boolean help(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i = 0, j = 0, diff = 0;
        while (i < ca.length && j < cb.length) {
            if (ca[i] == cb[j]) {
                i++;
                j++;
            } else {
                diff += 1;
                j += 1;
            }
        }
        return j == ca.length || diff == 1;
    }

    @Test
    public void test(){
        String []words = new String[]{"bdca","bda","ca","dca","a"};
        int i = longestStrChain(words);
        System.out.println(i);
    }
}
