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
            int[] inDegree = new int[numCourses]; // ������飬��¼ÿ���ڵ�����
            List<List<Integer>> adjList = new ArrayList<>(); // �ڽӱ���¼ÿ���ڵ�ĺ�̽ڵ�
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }
            // �������޿γ̽�ͼ���������������ڽӱ�
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                inDegree[course]++;
                adjList.get(preCourse).add(course);
            }
            Queue<Integer> queue = new LinkedList<>(); // ������Ϊ0�Ľڵ�
            // �����Ϊ0�Ľڵ����
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int visited = 0; // ��¼�ѷ��ʵĽڵ���
            int[] order = new int[numCourses]; // �����������Ľ��
            // ������������
            while (!queue.isEmpty()) {
                int course = queue.poll();
                visited++;
                order[visited - 1] = course; // ���ýڵ���������飬����洢
                // ���ýڵ�����к�̽ڵ����ȼ�1
                for (int nextCourse : adjList.get(course)) {
                    inDegree[nextCourse]--;
                    // �����̽ڵ����Ϊ0���������
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
            if (visited == numCourses) { // ������ʵĽڵ��������ܽڵ�����˵��ͼ�������޻�ͼ������������пγ̵�ѧϰ
                return order;
            } else {
                return new int[0]; // ���򷵻�һ��������
            }
        }
    }
}
