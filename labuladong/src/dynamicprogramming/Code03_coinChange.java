package dynamicprogramming;

import java.util.Arrays;

public class Code03_coinChange {
    int coinChange_1(int[] coins, int amount) {
        // ��ĿҪ������ս���� dp(amount)
        return dp_1(coins, amount);
    }

    // ���壺Ҫ�ճ���� n������Ҫ dp(coins, n) ��Ӳ��
    int dp_1(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // ����������Ľ��
            int subProblem = dp_1(coins, amount - coin);
            // �������޽�������
            if (subProblem == -1) continue;
            // ����������ѡ�����Ž⣬Ȼ���һ
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
     * �Զ����µݹ飬��һ������¼��¼�Ѿ��ݹ���������⣬�����ص������⣬��ɵ�ʱ���˷ѣ�
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
     * д��dp״̬ת�Ʒ��̣�ʹ��dp��������ǰ��������Ĵ𰸲���¼���Ե����ϼ�������Ĵ�
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
            //����Ϊʲô����Ҫ��֮ǰ��dp[i] ���ܶһ��Ľ���-1�أ���ΪMath.min(dp[i], 1 + dp[i - coin]);����ȡ��Сֵ���������һ������Ĵ�Ϊ -1��������ȡ�����ⲻ�����Ĵ���������һ�μ��㣬
            //��ô�����Ҳ�Ǵ���𰸡�
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }


}
