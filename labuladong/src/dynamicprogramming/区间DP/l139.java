package dynamicprogramming.区间DP;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName l139
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/23 22:00
 * @Version 1.0
 */
public class l139 {
    public boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean []dp = new boolean[n + 1];//dp数组定义:dp[i]前i个字符是否可以被拆分
        dp[0] = true;
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
