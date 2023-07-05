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
        int []dp = new int[n + 10];
        int res = 0;
        Arrays.fill(dp,1);
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            for (var entry: map.entrySet()) {
                if (Math.abs(cs[i - 1] - entry.getKey()) <= k){
                    ArrayList<Integer> cur = entry.getValue();
                    for (int id: cur){
                        dp[i] = Math.max(dp[i], dp[id] + 1);
                    }
                }
            }
            if (!map.containsKey(cs[i - 1])){
                map.put(cs[i - 1], new ArrayList<>());
                map.get(cs[i - 1]).add(i);
            }else{
                map.get(cs[i - 1]).add(i);
            }
            res = Math.max(res , dp[i]);
        }
        return res;
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
