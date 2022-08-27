package com.xgl.tree;

import org.junit.Test;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(1);
        head.setLeft(new Node(3));
        head.setRight(new Node(2));
        head.getLeft().setLeft(new Node(5));
        head.getLeft().setRight(new Node(3));
        head.getRight().setRight(new Node(9));
        Integer maxWidth = new TreeMaxWidth().getMaxWidth(head);
        System.out.println(maxWidth);
    }


    public Integer getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        HashMap<Node, Integer> levelMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Integer curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            }else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes =1;
            }
            if (cur.getLeft() != null) {
                levelMap.put(cur.getLeft(), curNodeLevel + 1);
                queue.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                levelMap.put(cur.getRight(), curNodeLevel + 1);
                queue.add(cur.getRight());
            }
        }

        return Math.max(max, curLevelNodes);
    }


}
