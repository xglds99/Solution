package com.xgl.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	//µã¼¯
	public HashMap<Integer,Node> nodes;
	//±ß¼¯
	public HashSet<Edge> edges;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}


}
