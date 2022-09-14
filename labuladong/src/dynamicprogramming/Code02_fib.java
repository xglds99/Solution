package dynamicprogramming;

public class Code02_fib {
    /**
     * ����쳲��������е�״̬ת�Ʒ��̣���ǰ״ֻ̬��֮ǰ������״̬�йأ���ʵ������Ҫ��ô����һ�� DP table ���洢���е�״̬��ֻҪ��취�洢֮ǰ������״̬�����ˡ�
     * @param n
     * @return
     */
    int fib_1(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // �ֱ���� dp[i - 1] �� dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // ��������
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    int fib_2(int n){
        int []dp =  new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
