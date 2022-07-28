package com.xgl.graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;
    public int out;
    //��������ڽӵĵ�
    public ArrayList<Node> nexts;
    //������������ı�
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }


    public Node getNodeByIndex(int i){
        return this.nexts.get(i);
    }
}
