package Graph.���·������;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName l1293
 * @Description
 * @Author xgl
 * @Date 2023/7/6 15:50
 * @Version 1.0
 */
public class l1293 {

    /**
     * ����һ�� m * n ����������ÿ����Ԫ���� 0���գ����� 1���ϰ����
     * ÿһ�������������ڿհ׵�Ԫ�����ϡ��¡������ƶ���
     * ����� ��� �������� k ���ϰ�����ҳ������Ͻ� (0, 0) �����½� (m-1, n-1) �����·����
     * ������ͨ����·������Ĳ���������Ҳ���������·�����򷵻� -1 ��
     *
     * @param grid
     * @param k
     * @return
     */
    private static final int INF = Integer.MAX_VALUE / 2;
    private static final int[][] dirctions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) return dist[x][y];
            for (int[] d : dirctions) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
                if (dist[newx][newy] < INF || dist[newx][newy] <= dist[x][y] + 1) continue;
                if (grid[newx][newy] == 0) {
                    dist[newx][newy] = dist[x][y] + 1;
                    queue.add(new int[]{newx, newy});
                } else if (grid[newx][newy] == 1) {
                    if (k > 0) {
                        dist[newx][newy] = dist[x][y] + 1;
                        queue.add(new int[]{newx, newy});
                        k--;
                    }
                }
            }
        }
        return -1;
    }

}
