package com.xgl.graph;

import java.util.*;
import java.util.Map.Entry;

// no negative weight
public class Code06_Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private Node[] nodes;
        private HashMap<Node, Integer> heapIndexMap;
        private HashMap<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }

    /**
     * 算法思想：把顶点分为两个集合，分为已求出最短路径的顶点集合S，初始时S只有一个起始原点，以后每求出一个最短路径v--->u,就将u加入到集合S中
     * 直到所有顶点被加入到集合S中，另一个集合U为未确定最短路径的点，在代码中用一个bool数组即可表示是否被计算出最短路径
     * 在向S中添加顶点，总保持从原点v到S中各顶点的最短路径长度不大于从原点v到U中任何顶点的最短路径长度。
     * 也就是说每次从集合U中选择点的时候，选择距离源点v路径最小的那个点，然后以点u为新的中间节点，更新集合U中的最短路径。
     * eg.若刚向S中添加的是顶点u，对于U中每个顶点j，若u-->j有边且权值为Wuj，原来从顶点v到j的路径长度Cvj 大于从顶点v到顶点u的长度与Wuj之和，更新顶点j的最短路径。
     *
     * @param graph 邻接矩阵
     * @param v     起始原点
     * @return
     */
    public static int[] dijkstra(int[][] graph, int v) {
        int INF = Integer.MAX_VALUE / 2;
        int n = graph.length;
        int[] dist = new int[n]; //记录x到每个点的最短路径
        int[] path = new int[n];
        int[] S = new int[n];//记录这个点是否已经被计算出最短路径。
        for (int i = 0; i < n; i++) {
            dist[i] = graph[v][i];
            S[i] = 0;
            if (graph[v][i] < INF) {
                path[i] = v;
            } else {
                path[i] = -1;
            }
        }
        S[v] = 1;
        path[v] = 0;
        int minDis, u = 0;
        for (int i = 0; i < n; ++i) {
            minDis = INF;
            for (int j = 0; j < n; ++j)
                //每次从未被计算出最短路径的顶点中选出距离最短的点u。
                if (S[j] == 0 && dist[j] < minDis) {
                    u = j;
                    minDis = dist[j];
                }
            S[u] = 1;
            for (int j = 0; j < n; ++j)
                //以u为中间结点，若路径小于原先的最短路径则更新。
                if (S[j] == 0) {
                    if (graph[u][j] < INF && dist[u] + graph[u][j] < dist[j]) {
                        dist[j] = dist[u] + graph[u][j];
                        path[j] = u;
                    }
                }
        }
        return dist;
    }

    // Dijkstra 算法模板，堆优化版 堆优化了每次找离起点最近的点的时间复杂度。
    // 返回从 start 到每个点的最短路
    //将图转换成邻接表来优化对于每一个中间结点u，更新其临边的时间。
    private int[] dijkstra(List<int[]>[] g, int start) {
        var dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int x = p[0], d = p[1];
            if (d > dist[x]) continue;
            for (var e : g[x]) {
                int y = e[0];
                int newDist = d + e[1];
                if (newDist < dist[y]) {
                    dist[y] = newDist;
                    pq.offer(new int[]{y, newDist});
                }
            }
        }
        return dist;
    }
}
