package dynamicprogramming.线性DP;

public class l458 {
    /**
     * 当最大测试轮数为 iterations 时，需要找到使得 (iterations+1)i≥buckets(\textit{iterations} + 1)^i \ge \textit{buckets}(iterations+1)
     * i
     *  ≥buckets 成立的最小的 iii，即为至少需要的小猪数量。令 states=iterations+1\textit{states} = \textit{iterations} + 1states=iterations+1，
     *  则至少需要的小猪数量是 ?log?statesbuckets?\lceil \log_{\textit{states}} \textit{buckets} \rceil?log
     * states
     * @return
     */
    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            int states = minutesToTest / minutesToDie + 1;
            int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-5);
            return pigs;
        }
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;
        int[][] combinations = new int[buckets + 1][buckets + 1];
        combinations[0][0] = 1;
        int iterations = minutesToTest / minutesToDie;
        int[][] dp = new int[buckets + 1][iterations + 1];
        for (int i = 0; i < buckets; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= iterations; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < buckets; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
            }
            for (int j = 1; j <= iterations; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] += dp[k][j - 1] * combinations[i][i - k];
                }
            }
            if (dp[i][iterations] >= buckets) {
                return i;
            }
        }
        return 0;
    }
}
