package Graph;

import java.util.HashSet;
import java.util.Set;

public class l1254 {
    public  int closedIsland(int [][]grid){
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m ,n)){
                    res++;
                }
            }
        }
        return  res;
    }

    private boolean dfs(int [][]grid, int i, int j, int m, int n){
        if (i < 0 || i >= m || j <0 || j >= n) return false;
        if (grid[i][j] == 1) return true;
        grid[i][j] = -1;
        boolean r1 = dfs(grid, i - 1, j, m, n);
        boolean r2 = dfs(grid, i + 1, j, m, n);
        boolean r3 = dfs(grid, i, j - 1, m, n);
        boolean r4 = dfs(grid,i , j + 1,m , n);
        return  r1 && r2 && r3 && r4;
    }
}
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                uf.union(i * n, 0);
            }
            if (grid[i][n - 1] == 0) {
                uf.union(i * n + n - 1, 0);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 0) {
                uf.union(j, 0);
            }
            if (grid[m - 1][j] == 0) {
                uf.union((m - 1) * n + j, 0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (i > 0 && grid[i - 1][j] == 0) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }

        Set<Integer> cnt = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    cnt.add(uf.find(i * n + j));
                }
            }
        }
        int total = cnt.size();
        if (cnt.contains(uf.find(0))) {
            total--;
        }
        return total;
    }
}

