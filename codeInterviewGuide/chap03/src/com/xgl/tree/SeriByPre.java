package com.xgl.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SeriByPre {

    public static void main(String[] args) {
        String s = "1,2,3,4,";
        String[] split = s.split(",");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.print(s1);
        }
    }




    public static String seribypre(Node head){
        if (head == null){
            return "#_";
        }
        String res = head.getValue() + "_";
        res += seribypre(head.getLeft());
        res += seribypre(head.getRight());
        return res;
    }

    public static Node process(String res){
        String[] s = res.split("_");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        return reconByPreString(queue);
    }

    public static Node reconByPreString(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.setLeft(reconByPreString(queue));
        head.setLeft(reconByPreString(queue));
        return head;
    }
}
