package dynamicprogramming.ÏßÐÔDP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class l403 {

    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final HashMap<String, Boolean> memo = new HashMap<>();

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++){
            map.put(stones[i], i);
        }

        if (!map.containsKey(1))return false;
        return dfs(stones,1,1,n);
    }

    /**
     *
     * @param stones
     * @param start
     * @param k
     * @param n
     * @return
     */
    public boolean dfs(int[] stones, int start, int k, int n) {
        String key = start + "_" + k;
        if (memo.containsKey(key))return memo.get(key);
        if (start == n - 1) return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) continue;
            int next = stones[start] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, map.get(next), k + i, n);
                memo.put(key, cur);
                if (cur) return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
