/**
 * @author xgl
 * @date 2023/6/26 21:14
 */
public class l2435 {
    /**
     * @return int
     * @Author xgl
     * @Description ����һ���±�� 0 ��ʼ�� m x n �������� grid ��һ������ k �������� (0, 0) ������
     * ÿһ��ֻ���� �� ������ �� ������Ҫ�����յ� (m - 1, n - 1) ��
     * <p>
     * ���㷵��·�����ܱ� k ������·����Ŀ�����ڴ𰸿��ܴܺ󣬷��ش𰸶� 109 + 7 ȡ�� �Ľ����
     * @Date 21:14 2023/6/26
     * @Param [grid, k]
     **/
    public int numberOfPaths(int[][] grid, int k) {
        //1.dp���鶨�� dp[i][j][v] ��0��0������i��j��kȡģ��v�ĺϷ�·������
        long[][][] dp = new long[grid.length + 1][grid[0].length + 1][k];
        dp[0][1][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i + 1][j + 1][(l + grid[i][j]) % k] =
                            (dp[i + 1][j + 1][(l + grid[i][j]) % k] + dp[i][j + 1][l] + dp[i + 1][j][l])
                            % 1000000007;
                }
            }
        }
        return (int) dp[grid.length][grid[0].length][0];
    }
}
