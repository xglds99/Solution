package Graph.最短路径问题;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @ClassName l1091
 * @Description
 * @Author xgl
 * @Date 2023/7/6 16:02
 * @Version 1.0
 */
public class l1091 {
    private static int INF = Integer.MAX_VALUE / 2;

    /**
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     * 路径途经的所有单元格的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1)return -1;
        int [][]dist = new int[n + 10][n + 10];
        for(var d: dist){
            Arrays.fill(d, INF);
        }
        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;
        while(!queue.isEmpty()){
            int []arr = queue.poll();
            int x = arr[0], y = arr[1];
            if(x == n - 1 && y == n - 1 ){
                return dist[x][y];
            }
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j<= 1; j++){
                    if(x + i < 0 || x + i >= n || y + j < 0|| y + j >= n)continue;
                    //如果此时dist[x + i][y + j] <= dist[x][y] + 1说明(x+ i,y +j)已经被访问过，且距离开始节点的最短路径长度为dist[x + i][y + j]
                    if(grid[x + i][y + j] == 1 || dist[x + i][y + j] <= dist[x][y] + 1)continue;
                    dist[x + i][y + j] = dist[x][y] + 1;
                    queue.offer(new int[]{x + i, y + j});
                }
            }
        }
        return -1;
    }
}
