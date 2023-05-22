package dynamicprogramming.线性DP;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/5/17 17:00
 */
public class l2684 {

        int mx = 0;
        int [][]memo;
        public int maxMoves(int[][] grid) {
            memo = new int[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++)
                Arrays.fill(memo[i], - 1);
            for(int i = 0 ; i < grid.length; i++)
                mx = Math.max(mx, dfs(grid, i, 0));
            return mx;
        }

        //dp[i][j]的定义 从i，j出发能移动的最大次数
        public int dfs(int [][]grid, int i ,int j){
            if(i < 0 || i > grid.length || j < 0 || j > grid[0].length){
                return 0;
            }
            if(memo[i][j] != -1)return memo[i][j];
            int t = 0;
            boolean flag = false;
            if(i- 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]){
                t = Math.max(t, dfs(grid, i - 1, j + 1));
                flag = true;
            }
            if( j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]){
                t = Math.max(t, dfs(grid, i, j + 1)) ;
                flag = true;
            }
            if( i + 1 < grid.length && j + 1 < grid[0].length &&  grid[i + 1][j + 1]> grid[i][j]){
                t = Math.max(t, dfs(grid, i + 1, j + 1));
                flag = true;
            }
            memo[i][j] = flag ? t + 1: t;
            if(flag) return t + 1;
            else return t;
        }
    class Solution {
        public int maxMoves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            var f = new int[m][n];
            for (int j = n - 2; j >= 0; j--)
                for (int i = 0; i < m; i++)
                    for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++)
                        if (grid[k][j + 1] > grid[i][j])
                            f[i][j] = Math.max(f[i][j], f[k][j + 1] + 1);
            int ans = 0;
            for (int i = 0; i < m; i++)
                ans = Math.max(ans, f[i][0]);
            return ans;
        }
    }


    public int maxMovesDP(int [][]grid){
            int m = grid.length;
            int n = grid[0].length;
            int [][]dp = new int[m][n];

                for (int j = n -2; j >= 0; j--){
                    for (int i = 0; i < m; i ++){
                    if( i - 1 >= 0 && grid[i - 1][j + 1] > grid[i][j]){
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
                    }
                    if(grid[i][j + 1] > grid[i][j])dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                    if (i + 1 < m && grid[i + 1][j + 1] > grid[i][j]) dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                }
            }
            int res = 0;
        for (int i = 0; i <m; i++) {
            res = Math.max(res ,dp[i][0]);
        }
        return  res;
    }

}
