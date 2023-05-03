package 图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xgl
 * @date 2023/5/3 10:25
 */
public class l2658 {

    public int findMaxFish(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(i, j, grid));
            }
        }
        return res;
    }
    public int dfs(int i, int j , int [][]grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int cnt = grid[i][j];
        grid[i][j] = 0;
        cnt += dfs(i, j + 1,grid);
        cnt += dfs(i, j - 1,grid);
        cnt += dfs(i - 1, j,grid);
        cnt += dfs(i + 1, j,grid);
        return cnt;
    }


    class Solution {
        private int[] directions = new int[]{-1, 0, 1, 0, -1};
        public int findMaxFish(int[][] grid) {
            // 广度优先遍历
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for(int i = 0;i<m;i++) {
                for(int j = 0;j<n;j++) {
                    if(grid[i][j]>0) {
                        ans = Math.max(ans, bfs(grid, i, j));
                    }
                }
            }
            return ans;
        }

        private int bfs(int[][] grid, int row, int col) {
            int m = grid.length, n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{row, col});
            int cnt = grid[row][col];
            grid[row][col] = 0;
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                for(int k = 0;k<4;k++) {
                    int r = poll[0]+directions[k];
                    int c = poll[1]+directions[k+1];
                    if(r>=0&&r<m&&c>=0&&c<n&&grid[r][c]>0) {
                        cnt += grid[r][c];
                        grid[r][c] = 0;
                        queue.add(new int[]{r,c});
                    }
                }
            }
            return cnt;
        }
    }
}
