package com.xgl.graph;

public class Code07_Floyd {
    int [][] Floyd(int[][] graph) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] A = new int[INF][INF];
        int[][] path = new int[INF][INF];
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = graph[i][j];
                if (i != j && graph[i][j] < INF) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] > A[i][k] + A[k][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
        return A;
    }
}
