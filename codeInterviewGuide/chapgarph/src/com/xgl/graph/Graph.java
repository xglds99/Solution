package com.xgl.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	//�㼯
	public HashMap<Integer,Node> nodes;
	//�߼�
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}


}
