package dynamicprogramming;

import java.util.Arrays;

public class Code03_coinChange {
    int coinChange_1(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp_1(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    int dp_1(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp_1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    //********************************************************************************************************************
    int dp[];

    int coinChange_2(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return dp_2(coins, amount);
    }

    /**
     * 自顶向下递归，用一个备忘录记录已经递归过的子问题，避免重叠子问题，造成的时间浪费！
     *
     * @param coins
     * @param amount
     * @return
     */
    int dp_2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != -2) {
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp_2(coins, amount - coin);
            if (subProblem == -1)
                continue;
            ans = Math.min(ans, subProblem + 1);
        }
        dp[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
        return dp[amount];
    }

    /**
     * 写出dp状态转移方程，使用dp数组计算出前面子问题的答案并记录，自底向上计算出最后的答案
     *
     * @param coins
     * @param amount
     * @return
     */
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
            //dp[i] = dp[i] == amount + 1 ? -1 : dp[i];
            //这里为什么不需要对之前的dp[i] 不能兑换的金额换成-1呢，因为Math.min(dp[i], 1 + dp[i - coin]);这里取较小值，如果有上一子问题的答案为 -1，那我们取子问题不成立的答案来进行下一次计算，
            //那么计算出也是错误答案。
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }


}
