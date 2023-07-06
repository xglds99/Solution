package Graph.���·������;

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
     * ����һ�� n x n �Ķ����ƾ��� grid �У����ؾ�������� ��ͨ·�� �ĳ��ȡ����������������·�������� -1 ��
     * �����ƾ����е� ��ͨ·�� ��һ���� ���Ͻ� ��Ԫ�񣨼���(0, 0)���� ���½� ��Ԫ�񣨼���(n - 1, n - 1)����·������·��ͬʱ��������Ҫ��
     * ·��;�������е�Ԫ���ֵ���� 0 ��
     * ·�����������ڵĵ�Ԫ��Ӧ���� 8 ������֮һ ����ͨ��������������Ԫ֮��˴˲�ͬ�ҹ���һ���߻���һ���ǣ���
     * ��ͨ·���ĳ��� �Ǹ�·��;���ĵ�Ԫ��������
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
                    //�����ʱdist[x + i][y + j] <= dist[x][y] + 1˵��(x+ i,y +j)�Ѿ������ʹ����Ҿ��뿪ʼ�ڵ�����·������Ϊdist[x + i][y + j]
                    if(grid[x + i][y + j] == 1 || dist[x + i][y + j] <= dist[x][y] + 1)continue;
                    dist[x + i][y + j] = dist[x][y] + 1;
                    queue.offer(new int[]{x + i, y + j});
                }
            }
        }
        return -1;
    }
}
