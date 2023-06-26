package dynamicprogramming.线性DP;

import java.util.HashSet;
import java.util.List;

public class l139 {

    private HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict){
        set = new HashSet<>();
        set.addAll(wordDict);
        int n = s.length();
        boolean []dp = new boolean[n + 10]; //dp[i]，前i个字符串是否可以由字典中的单词拼接
        dp[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++) {
                if (dp[j - 1] && set.contains(s.substring(j-1, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }


}
