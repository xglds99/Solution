package com.xgl.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

	/**
	 * 深度优先遍历的非递归写法
	 * @param node
	 */
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}


	/**
	 * 邻接表使用递归进行dfs
	 * @param
	 */

	HashSet<Node> visited = new HashSet<>();
	public void dfsByR(Node head){
		if (head == null){
			return;
		}
		visited.add(head);
		System.out.println(head.value);
		head.nexts.forEach(node -> {
			if (!visited.contains(node)){
				dfsByR(node);
			}
		});
	}

	public static void main(String[] args) {

	}



}
