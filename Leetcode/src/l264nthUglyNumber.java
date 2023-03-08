public class l264nthUglyNumber {

    /**
     * ���n������
     *�û�û�˹� 2 ����С�������� 2���û�û�˹� 3 ����С�������� 3���û�û�˹� 5 ����С�������� 5��Ȼ���ڵõ���������ȡ��С�������µĳ�����
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        //dp���鶨�壬dp[i]Ϊ��i��������
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
