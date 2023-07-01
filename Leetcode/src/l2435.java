/**
 * @author xgl
 * @date 2023/6/26 21:14
 */
public class l2435 {
    /**
     * @return int
     * @Author xgl
     * @Description 给你一个下标从 0 开始的 m x n 整数矩阵 grid 和一个整数 k 。你从起点 (0, 0) 出发，
     * 每一步只能往 下 或者往 右 ，你想要到达终点 (m - 1, n - 1) 。
     * <p>
     * 请你返回路径和能被 k 整除的路径数目，由于答案可能很大，返回答案对 109 + 7 取余 的结果。
     * @Date 21:14 2023/6/26
     * @Param [grid, k]
     **/
    public int numberOfPaths(int[][] grid, int k) {
        //1.dp数组定义 dp[i][j][v] 从0，0出发到i，j对k取模的v的合法路径个数
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
