package com.xgl.graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public void bfsByR(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> isVisited = new HashSet<>();
        isVisited.add(node);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll);
            poll.nexts.forEach(x -> {
                if (!isVisited.contains(x)) {
                    queue.add(x);
                    isVisited.add(x);
                }
            });
        }
    }

    public void bfs_1(Node node) {
        if (node == null)
            return;
        HashSet<Node> isVisited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        isVisited.add(node);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll);
            poll.nexts.forEach(next -> {
                if (!isVisited.contains(next)) {
                    queue.add(next);
                    isVisited.add(next);
                }
            });
        }
    }


    public static void main(String[] args) {
        System.out.println("test rollBack!!!");
    }

}
