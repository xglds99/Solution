package dynamicprogramming.线性DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class l403 {

    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final HashMap<String, Boolean> memo = new HashMap<>();

    /**
     * 青蛙游戏
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        if (!map.containsKey(1)) return false;
        return dfs(stones, 1, 1, n);
    }

    /**
     * @param stones
     * @param start
     * @param k
     * @param n
     * @return
     */
    //从start出发，上一次跳了k步，是否可以到达最后一个格子
    public boolean dfs(int[] stones, int start, int k, int n) {
        String key = start + "_" + k;
        if (memo.containsKey(key)) return memo.get(key);
        if (start == n - 1) return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) continue; //保证只能向前走
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

    static class Solution {
        /**
         * 这样的「状态定义」所代表的含义：当前在第 iii 个位置，并且是以步长 kkk 跳到位置 iii 时，是否到达最后一块石子。
         * 那么对于 f[i][k] 是否为真，则取决于上一位置 jjj 的状态值，结合每次步长的变化为 [-1,0,1] 可知：
         * 可从 f[j][k?1] 状态而来：先是经过 k?1 的跳跃到达位置 jjj，再在原步长的基础上 +1，跳到了位置 iii。
         * 可从 f[j][k] 状态而来：先是经过 kkk 的跳跃到达位置 jjj，维持原步长不变，跳到了位置 iii。
         * 可从 f[j][k+1] 状态而来：先是经过 k+1k + 1k+1 的跳跃到达位置 jjj，再在原步长的基础上 -1，跳到了位置 iii。
         * 只要上述三种情况其中一种为真，则 f[i][j] 为真。
         * 至此，我们解决了动态规划的「状态定义」&「状态转移方程」部分。
         * 但这就结束了吗？还没有。
         * 我们还缺少可让状态递推下去的「有效值」，或者说缺少初始化环节。
         * 因为我们的 f[i][k]f[i][k]f[i][k] 依赖于之前的状态进行“或运算”而来，转移方程本身不会产生 true 值。因此为了让整个「递推」过程可滚动，我们需要先有一个为 true的状态值。
         * 这时候再回看我们的状态定义：当前在第 iii 个位置，并且是以步长 kkk 跳到位置 iii 时，是否到达最后一块石子。
         * 显然，我们事先是不可能知道经过「多大的步长」跳到「哪些位置」，最终可以到达最后一块石子。
         * 这时候需要利用「对偶性」将跳跃过程「翻转」过来分析：
         * 我们知道起始状态是「经过步长为 1」的跳跃到达「位置 1」，如果从起始状态出发，存在一种方案到达最后一块石子的话，那么必然存在一条反向路径，它是以从「最后一块石子」开始，并以「某个步长 kkk」开始跳跃，最终以回到位置 1。
         * 因此我们可以设 f[1][1]= true，作为我们的起始值。
         * 这里本质是利用「路径可逆」的性质，将问题进行了「等效对偶」。表面上我们是进行「正向递推」，但事实上我们是在验证是否存在某条「反向路径」到达位置 111。
         *
         * @param ss
         * @return
         */
        public boolean canCross(int[] ss) {
            int n = ss.length;
            // check first step
            if (ss[1] != 1) return false;
            //1.定义 dp[i][j]代表当前在位置i，上一次跳跃步长为j，是否可以到达终点。
            boolean[][] f = new boolean[n + 1][n + 1];
            f[1][1] = true;
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    int k = ss[i] - ss[j];
                    // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃
                    // 而从位置 j 发起的跳跃最多不超过 j + 1
                    // 因为每次跳跃，下标至少增加 1，而步长最多增加 1
                    //为什么 k<= j + 1呢
                    //因为从j的前一个位置跳k个单位到j，所以从j出最多能到j+1个位置
                    if (k <= j + 1) {
                        f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (f[n - 1][i]) return true;
            }
            return false;
        }
    }

}
