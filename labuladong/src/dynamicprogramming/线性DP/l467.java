package dynamicprogramming.线性DP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/7/1 16:25
 */
public class l467 {
    /**
    * @Author xgl
    * @Description
     * 定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的：
     *
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
     * 给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。
     * 核心在于求26个英文字母中，以每个字母为结尾的最长递增子串的长度，。
     * eg:以d为结尾，长度为3，那么子串就是 d,cd,bcd
     * 注意a的前一个字母可以是z
     * 因为base是一个循环的字符串，判断两个字符是否相邻可以 +26后对26取模是否等于一即可。
    * @Date 16:31 2023/7/1
    * @Param [s]
    * @return int
    **/
    public int findSubstringInWraproundString(String s) {
        int []dp = new int[26];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && (c - s.charAt(i - 1)  + 26) % 26 == 1){
                k++;
            }else{
                k = 1;
            }
            dp[c - 'a'] = Math.max(k,dp[c-'a']);
        }
        return Arrays.stream(dp).sum();
    }
}
