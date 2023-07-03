package backtrack;

/**
 * @ClassName l980
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 14:20
 * @Version 1.0
 */
public class l980 {
    private int res = 0;
    private int m;
    private int n;

    private int er;
    private int ec;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int cnt = 0;
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) cnt++;
                if (grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }else if (grid[i][j] == 2){
                    er = i;
                    ec = j;
                }
            }
        }
        dfs(grid, sr, sc,cnt);
        return res;
    }


    public void dfs(int[][] grid, int i, int j, int cnt) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1 || grid[i][j] == 3) return;
        cnt--;
        if (cnt == 0) {
            if (er == i && ec == j) res++;
            return;
        }
        grid[i][j] = 3;
        dfs(grid, i - 1, j, cnt);
        dfs(grid, i + 1, j, cnt);
        dfs(grid, i, j - 1, cnt);
        dfs(grid, i, j + 1, cnt);
        grid[i][j] = 0;
    }
}
