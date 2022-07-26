package com.xgl.tree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class TestAvt {



    public static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType() {
        }

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(Node head){
        return isAVL(head).isBalanced;
    }

    /***
     * 判断是否是一颗平衡二叉树
     * 递归套路，直接判断平衡二叉树的条件:
     * 1、左右子树都是平衡二叉树
     * 2、左子树与右子树的高度差不超过1
     * 构造递归直接进入递归的最后一层来写代码
     * 比如直接
     * @param head
     * @return
     */
    public static ReturnType isAVL(Node head){
        if (head == null){
            return new ReturnType(true, 0);
        }
        ReturnType lefData = isAVL(head.getLeft());
        ReturnType rightData = isAVL(head.getRight());

        int height = Math.max(lefData.height, rightData.height) + 1;
        boolean isBalanced = lefData.isBalanced && rightData.isBalanced &&
                Math.abs((lefData.height) - rightData.height) < 2 ;
        return new ReturnType(isBalanced, height);
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.setLeft(new Node(4));
        head.getLeft().setLeft(new Node(2));
        head.getLeft().setRight(new Node(6));
        head.setRight(new Node(9));
        System.out.println(isBalanced(head));
    }
}
