package com.xgl.tree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Deque;
import java.util.LinkedList;

public class TestBst {


    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(0);
//        head.setLeft(new Node(4));
//        head.setRight(new Node(9));
//        head.getRight().setLeft(new Node(8));
//        head.getRight().setRight(new Node(10));
//        head.getLeft().setLeft(new Node(2));
//        head.getLeft().setRight(new Node(6));

        boolean bst = isBst(head);
        System.out.println(bst);
    }

    private static Integer preValue = Integer.MIN_VALUE;

    /**
     * 判断是否是二叉搜索树
     * 中序遍历，若遍历序列不是递增的则不事搜索二叉树
     *
     * @param head
     * @return
     */
    public static boolean isBst(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLefBst = isBst(head.getLeft());
        if (!isLefBst) {
            return false;
        }
        if (head.getValue() < preValue) {
            return false;
        } else {
            preValue = head.getValue();
        }
        return isBst(head.getRight());
    }


    public static boolean isBstUnRecu(Node head) {
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Deque<Node> deque = new LinkedList<>();
            while (!deque.isEmpty() || head != null) {
                if (head != null) {
                    deque.push(head);
                    head = head.getLeft();

                } else {
                    head = deque.pop();
                    if (head.getValue() < preValue) {
                        return false;
                    } else {
                        preValue = head.getValue();
                    }
                    head = head.getLeft();
                }
            }
        }
        return true;
    }


    public static class ReturnType {
        boolean isBst;
        int min;
        int max;

        public ReturnType(boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return null;
        }

        ReturnType rightData = process(head.getRight());
        ReturnType leftData = process(head.getLeft());

        int min = head.getValue();
        int max = head.getValue();

        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }

        boolean isBst = true;
        if (leftData != null && (!leftData.isBst || head.getValue() <= leftData.max)) {
            isBst = false;
        }
        if (rightData != null && (!rightData.isBst || head.getValue() >= rightData.min)) {
            isBst = false;
        }
        return new ReturnType(isBst, min, max);
    }
    public static boolean isBst_1(Node head){
        return process(head).isBst;
    }
}
