package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xgl
 * @date 2023/6/26 15:56
 */
public class l207 {
    public boolean canFinish(int n, int [][]prerequisites){
        int []inDegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        //根据先修课程建图，更新入度数组和邻接表
        for(int []p: prerequisites){
            int course = p[0];
            int preCourse = p[1];
            inDegree[course]++;
            adjList.get(preCourse).add(course);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        //将入度为0的点加入队列
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int cnt  = 0;//记录当前修的课程个数
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            cnt++;
            for(Integer next: adjList.get(cur)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return cnt == n;
    }
}
