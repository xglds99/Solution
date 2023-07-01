package dynamicprogramming.状压DP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/7/1 16:13
 */
public class l473 {
        /**
        * @Author xgl
        * @Description 你将得到一个整数数组 matchsticks ，其中 matchsticks[i]
         * 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形
         * 。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
         *
         * 如果你能使这个正方形，则返回 true ，否则返回 false 。
        * @Date 2023/7/1
        * @Param [matchsticks]
        * @return boolean
        **/
        public boolean makesquare(int[] matchsticks) {
            int totalLen = Arrays.stream(matchsticks).sum();
            if (totalLen % 4 != 0) {
                return false;
            }
            int len = totalLen / 4, n = matchsticks.length;
            int[] dp = new int[1 << n];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int s = 1; s < (1 << n); s++) {
                for (int k = 0; k < n; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    int s1 = s & ~(1 << k);
                    if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                        dp[s] = (dp[s1] + matchsticks[k]) % len;
                        break;
                    }
                }
            }
            return dp[(1 << n) - 1] == 0;
        }


}
