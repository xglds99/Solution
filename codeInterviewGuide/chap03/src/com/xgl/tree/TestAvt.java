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
     * �ж��Ƿ���һ��ƽ�������
     * �ݹ���·��ֱ���ж�ƽ�������������:
     * 1��������������ƽ�������
     * 2�����������������ĸ߶Ȳ����1
     * ����ݹ�ֱ�ӽ���ݹ�����һ����д����
     * ����ֱ��
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
