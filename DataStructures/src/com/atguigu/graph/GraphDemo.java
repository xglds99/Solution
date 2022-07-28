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
    //存储顶点
    private List<String> vertexList;
    //使用邻接矩阵存储边
    private int[][] edges;
    //记录顶点个数
    private int numOfEdges;

    private boolean[] isVisited;

    public Graph(int n) {
        //初始化
        this.edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边

    /**
     * @param v1     表示顶点在vertexList的下标
     * @param v2
     * @param weight 边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges += 1;
    }

    /**
     * 得到第一个邻接节点的下表
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
     * 返回顶点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回节点i对应的数据
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
        //首先访问该节点
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置已经访问
        isVisited[i] = true;
        //查找节点i的第一个邻接点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w节点已经被访问过,找该节点下一个邻接节点
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历我们所有的节点，并进行dfs
    public void dfs() {
        //遍历所有的节点，并进行dfs【回溯】
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        System.out.println("\n");
    }

    public void bfs(boolean[] isVisited, int i) {
        int u; // 队列的头节点对应的下标
        int w; //邻接结点w
        //队列，记录节点的顺序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //访问节点
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.add(i);
        while (!queue.isEmpty()) {
            // 取出队列的头节点下标
            u = queue.removeFirst();
            // 得到第一个邻接结点的下表w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    // 标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                // 以u为前驱点，找w后面的下一个临界点
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