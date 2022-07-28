package com.xgl.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LowestAncestor {

    public static Node lca(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        Node cur = o1;
        while (cur != head) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        Node cur2 = o2;
        while (cur2 != fatherMap.get(cur2)) {
            cur2 = fatherMap.get(cur2);
            if (set1.contains(cur2)) {
                return cur2;
            }
        }
        return o2;
    }


    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        if (head.getLeft() != null)
            fatherMap.put(head.getLeft(), head);
        if (head.getRight() != null)
            fatherMap.put(head.getRight(), head);
        process(head.getLeft(), fatherMap);
        process(head.getRight(), fatherMap);
    }


    public Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.getLeft(), o1, o2);
        Node right = lowestAncestor(head.getRight(), o1, o2);

        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }


    public void postOrder(Node head) {
        if (head == null) {
            return;
        }
        if (head.getLeft() != null) {
            postOrder(head.getRight());
        }
        if (head.getRight() != null) {
            postOrder(head.getRight());
        }
        System.out.println(head);
    }


    @Test
    public void test() {
        String s = Integer.toString(1);
        System.out.println(2 + s);
        System.out.println(Integer.parseInt(2 + s));
    }
}
