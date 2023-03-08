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
     * �㷨˼�룺�Ѷ����Ϊ�������ϣ���Ϊ��������·���Ķ��㼯��S����ʼʱSֻ��һ����ʼԭ�㣬�Ժ�ÿ���һ�����·��v--->u,�ͽ�u���뵽����S��
     * ֱ�����ж��㱻���뵽����S�У���һ������UΪδȷ�����·���ĵ㣬�ڴ�������һ��bool���鼴�ɱ�ʾ�Ƿ񱻼�������·��
     * ����S����Ӷ��㣬�ܱ��ִ�ԭ��v��S�и���������·�����Ȳ����ڴ�ԭ��v��U���κζ�������·�����ȡ�
     * Ҳ����˵ÿ�δӼ���U��ѡ����ʱ��ѡ�����Դ��v·����С���Ǹ��㣬Ȼ���Ե�uΪ�µ��м�ڵ㣬���¼���U�е����·����
     * eg.������S����ӵ��Ƕ���u������U��ÿ������j����u-->j�б���ȨֵΪWuj��ԭ���Ӷ���v��j��·������Cvj ���ڴӶ���v������u�ĳ�����Wuj֮�ͣ����¶���j�����·����
     *
     * @param graph �ڽӾ���
     * @param v     ��ʼԭ��
     * @return
     */
    public static int[] dijkstra(int[][] graph, int v) {
        int INF = Integer.MAX_VALUE / 2;
        int n = graph.length;
        int[] dist = new int[n]; //��¼x��ÿ��������·��
        int[] path = new int[n];
        int[] S = new int[n];//��¼������Ƿ��Ѿ�����������·����
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
                //ÿ�δ�δ����������·���Ķ�����ѡ��������̵ĵ�u��
                if (S[j] == 0 && dist[j] < minDis) {
                    u = j;
                    minDis = dist[j];
                }
            S[u] = 1;
            for (int j = 0; j < n; ++j)
                //��uΪ�м��㣬��·��С��ԭ�ȵ����·������¡�
                if (S[j] == 0) {
                    if (graph[u][j] < INF && dist[u] + graph[u][j] < dist[j]) {
                        dist[j] = dist[u] + graph[u][j];
                        path[j] = u;
                    }
                }
        }
        return dist;
    }

    // Dijkstra �㷨ģ�壬���Ż��� ���Ż���ÿ�������������ĵ��ʱ�临�Ӷȡ�
    // ���ش� start ��ÿ��������·
    //��ͼת�����ڽӱ����Ż�����ÿһ���м���u���������ٱߵ�ʱ�䡣
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
