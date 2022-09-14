package dynamicprogramming;

public class Code03_coinChange {
    int coinChange(int[] coins, int amount) {
        // ��ĿҪ������ս���� dp(amount)
        return dp(coins, amount);
    }

    // ���壺Ҫ�ճ���� n������Ҫ dp(coins, n) ��Ӳ��
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // ����������Ľ��
            int subProblem = dp(coins, amount - coin);
            // �������޽�������
            if (subProblem == -1) continue;
            // ����������ѡ�����Ž⣬Ȼ���һ
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
