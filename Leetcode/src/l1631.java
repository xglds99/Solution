import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName l1631
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 19:10
 * @Version 1.0
 */
public class l1631 {

    private int m;
    private int n;
    private int res = 1000000000;

    private LinkedList<Integer> list = new LinkedList<>();
    public int minimumEffortPath(int[][] heights) {
         m = heights.length;
         n = heights[0].length;
        boolean [][] visited = new boolean[m][n];
        dfs(heights,0,0,visited);
        return res;
    }

    public void dfs(int [][]heights, int i, int j , boolean [][]visited){
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])return;
        visited[i][j] = true;
        list.addLast(heights[i][j]);
        if (i == m - 1 && j == n - 1){
            int cur = 0;
            for (int k = 1; k < list.size(); k++){
                cur = Math.max(cur, Math.abs(list.get(k) - list.get(k - 1)));
            }
            res = Math.min(res, cur);
        }
        dfs(heights,i - 1,j,visited);
        dfs(heights,i  + 1,j,visited);
        dfs(heights,i ,j - 1,visited);
        dfs(heights,i ,j + 1,visited);
        visited[i][j] = false;
        list.removeLast();
    }
}
