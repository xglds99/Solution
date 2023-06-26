package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xgl
 * @date 2023/6/26 16:16
 */
public class l210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses]; // 入度数组，记录每个节点的入度
            List<List<Integer>> adjList = new ArrayList<>(); // 邻接表，记录每个节点的后继节点
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }
            // 根据先修课程建图，更新入度数组和邻接表
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                inDegree[course]++;
                adjList.get(preCourse).add(course);
            }
            Queue<Integer> queue = new LinkedList<>(); // 存放入度为0的节点
            // 将入度为0的节点入队
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int visited = 0; // 记录已访问的节点数
            int[] order = new int[numCourses]; // 存放拓扑排序的结果
            // 进行拓扑排序
            while (!queue.isEmpty()) {
                int course = queue.poll();
                visited++;
                order[visited - 1] = course; // 将该节点加入结果数组，倒序存储
                // 将该节点的所有后继节点的入度减1
                for (int nextCourse : adjList.get(course)) {
                    inDegree[nextCourse]--;
                    // 如果后继节点入度为0，将其入队
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
            if (visited == numCourses) { // 如果访问的节点数等于总节点数，说明图是有向无环图，可以完成所有课程的学习
                return order;
            } else {
                return new int[0]; // 否则返回一个空数组
            }
        }
    }
}
