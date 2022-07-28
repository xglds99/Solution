package com.atguigu.graph;

import java.util.*;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(2, 1, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.showGraph();
        graph.dfs();
        graph.bfs();
    }
}

class Graph {
    //�洢����
    private List<String> vertexList;
    //ʹ���ڽӾ���洢��
    private int[][] edges;
    //��¼�������
    private int numOfEdges;

    private boolean[] isVisited;

    public Graph(int n) {
        //��ʼ��
        this.edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //����ڵ�
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //��ӱ�

    /**
     * @param v1     ��ʾ������vertexList���±�
     * @param v2
     * @param weight �ߵ�Ȩֵ
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges += 1;
    }

    /**
     * �õ���һ���ڽӽڵ���±�
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ���ض���ĸ���
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * ���رߵĸ���
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * ���ؽڵ�i��Ӧ������
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public void dfs(boolean isVisited[], int i) {
        //���ȷ��ʸýڵ�
        System.out.print(getValueByIndex(i) + "->");
        //���ڵ������Ѿ�����
        isVisited[i] = true;
        //���ҽڵ�i�ĵ�һ���ڽӵ�
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //���w�ڵ��Ѿ������ʹ�,�Ҹýڵ���һ���ڽӽڵ�
            w = getNextNeighbor(i, w);
        }
    }

    //��dfs�������أ������������еĽڵ㣬������dfs
    public void dfs() {
        //�������еĽڵ㣬������dfs�����ݡ�
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        System.out.println("\n");
    }

    public void bfs(boolean[] isVisited, int i) {
        int u; // ���е�ͷ�ڵ��Ӧ���±�
        int w; //�ڽӽ��w
        //���У���¼�ڵ��˳��
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //���ʽڵ�
        System.out.print(getValueByIndex(i) + "=>");
        //���Ϊ�ѷ���
        isVisited[i] = true;
        //���ڵ�������
        queue.add(i);
        while (!queue.isEmpty()) {
            // ȡ�����е�ͷ�ڵ��±�
            u = queue.removeFirst();
            // �õ���һ���ڽӽ����±�w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //�Ƿ���ʹ�
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // ����Ѿ�����
                    isVisited[w] = true;
                    //���
                    queue.addLast(w);
                }
                // ��uΪǰ���㣬��w�������һ���ٽ��
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs(){
        Arrays.fill(isVisited, false);
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
        System.out.println("\n");
    }


}