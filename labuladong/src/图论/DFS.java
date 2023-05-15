package ͼ��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xgl
 * @date 2023/5/6 10:04
 */
public class DFS {


    /**
     * ͼ�ڽӾ���������ȱ����͹�����ȱ���
     */

    public boolean[] isVisit;           //�Ƿ񱻷��ʹ����������
    public boolean[] bfsVisit;          //�Ƿ񱻷��ʹ�,�������

    public class Graph {
        public List<String> vertex;     //���㼯��
        public int[][] matrix;          //�ڽӾ��󼯺�
        public int edge;                //����

        /**
         * ����
         *
         * @param n ������
         */
        public Graph(int n) {
            vertex = new ArrayList<String>(n);
            matrix = new int[n][n];
            isVisit = new boolean[n];
            bfsVisit = new boolean[n];
        }

        /**
         * ��ӽڵ�
         *
         * @param v �ڵ�����
         */
        public void addVertex(String v) {
            vertex.add(v);
        }

        /**
         * �����ڽӾ�������
         *
         * @param i
         * @param j
         * @param val
         */
        public void addMatrix(int i, int j, int val) {
            this.matrix[i][j] = val;
            this.matrix[j][i] = val;
        }

        public int[][] getMatrix() {
            return this.matrix;
        }
    }

    /**
     * ����ͼ
     *
     * @param n
     * @return
     */
    public Graph createGraph(int n) {
        return new Graph(n);
    }

    /**
     * �ڽӾ���˳��洢
     *
     * @param graph
     */
    public void createMatrix(Graph graph) {
        /**
         *    V1 V2 V3 V4 V5 V6 V7 V8
         * V1 0  1  1  0  0  0  0  0
         * V2 1  0  0  1  1  0  0  0
         * V3 1  0  0  0  0  1  1  0
         * V4 0  1  0  0  0  0  0  1
         * V5 0  1  0  0  0  0  0  1
         * V6 0  0  1  0  0  0  1  0
         * V7 0  0  1  0  0  1  0  0
         * V8 0  0  0  1  1  0  0  0
         */
        graph.addMatrix(0, 1, 1);
        graph.addMatrix(0, 2, 1);
        graph.addMatrix(1, 0, 1);
        graph.addMatrix(1, 3, 1);
        graph.addMatrix(1, 4, 1);
        graph.addMatrix(2, 0, 1);
        graph.addMatrix(2, 5, 1);
        graph.addMatrix(2, 6, 1);
        graph.addMatrix(3, 1, 1);
        graph.addMatrix(3, 7, 1);
        graph.addMatrix(4, 1, 1);
        graph.addMatrix(4, 7, 1);
        graph.addMatrix(5, 2, 1);
        graph.addMatrix(5, 6, 1);
        graph.addMatrix(6, 2, 1);
        graph.addMatrix(6, 5, 1);
        graph.addMatrix(7, 3, 1);
        graph.addMatrix(7, 4, 1);
    }

    /**
     * �ڽӾ���������ȱ���
     *
     * @param graph
     * @param i
     */
    public void dfsSort(Graph graph, int i) {
        if (isVisit[i]) return;
        isVisit[i] = true;
        System.out.print(graph.vertex.get(i) + " ");
        int[][] tmp = graph.getMatrix();
        for (int j = 0; j < graph.vertex.size(); j++) {
            if (tmp[i][j] == 1 && !isVisit[j]) dfsSort(graph, j);
        }
    }

    /**
     * �ڽӾ��������ȱ���
     *
     * @param graph
     */
    public void bfsSort(Graph graph, int i) {
        if (bfsVisit[i]) return;
        bfsVisit[i] = true;
        System.out.print(graph.vertex.get(i) + " ");
        Queue<Integer> queue = new LinkedList();
        queue.add(i);
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int j = 0; j < graph.vertex.size(); j++) {
                if (graph.getMatrix()[idx][j] == 1 && !bfsVisit[j]) {
                    bfsVisit[j] = true;
                    System.out.print(graph.vertex.get(j) + " ");
                    queue.add(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        String[] vertexs = {"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
        DFS graphTest = new DFS();
        Graph graph = graphTest.createGraph(n);
        for (String vertex : vertexs) {
            graph.addVertex(vertex);
        }
        graphTest.createMatrix(graph);
        /*int[][] data = graph.getMatrix();
        //System.out.println(Arrays.deepToString(data));
        //�����ڽӾ����ά����
        for (int[] tmp : data) {
            for (int x : tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        */
        System.out.println("�ڽӾ���������ȱ���");
        List<String> vertexList = graph.vertex;
        for (int i = 0; i < vertexList.size(); i++) {
            graphTest.dfsSort(graph, i);
        }
        System.out.println("");
        System.out.println("�ڽӾ��������ȱ���");
        for (int i = 0; i < vertexList.size(); i++) {
            graphTest.bfsSort(graph, i);
        }
    }


}
