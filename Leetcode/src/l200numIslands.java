import java.util.HashSet;

public class l200numIslands {

    public static int numIslands(char [][]grid){
       int m = grid.length;
       int n = grid[0].length;
       int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                   ans++;
                   infect(grid,i,j,m,n);
                }
            }
        }
        return ans;
    }

    private static void infect(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i > m || j <0 || j > n || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        infect(grid, i+1, j, m, n);
        infect(grid, i-1, j, m, n);
        infect(grid, i, j+1, m, n);
        infect(grid, i, j-1, m, n);
    }
}
