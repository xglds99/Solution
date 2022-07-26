package com.xgl.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TestCBT {

    /**
     * �ж�һ�����ǲ�����ȫ������
     * �������
     * 1���κ�һ�������������  ---> false
     * 2���ڲ�Υ��1�������£������һ��������Һ��Ӳ�˫ȫ����ʣ�µĽ��ȫ��ΪҶ�ӽڵ㣬���з�Ҷ�ӽڵ���--->false
     *
     * @param head
     * @return
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        while (!queue.isEmpty())  {
            Node curNode = queue.poll();
            if ((leaf && (curNode.getLeft() != null || curNode.getRight() != null)) ||
                    (curNode.getLeft() == null && curNode.getRight() != null)
            ) {
                return false;
            }
            if (curNode.getLeft() != null) {
                queue.add(curNode.getRight());
            }
            if (curNode.getRight() != null) {
                queue.add(curNode.getRight());
            }
            if (curNode.getLeft() == null || curNode.getRight() == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.setLeft(new Node(4));
        head.getLeft().setLeft(new Node(2));
        head.getLeft().setRight(new Node(6));
        head.setRight(new Node(9));
        head.getRight().setLeft(new Node(8));
        System.out.println(isCBT(head));
    }
}
