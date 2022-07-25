package com.xgl.tree;

public class TestBst {


    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(7);
        head.setLeft(new Node(4));
        head.setRight(new Node(9));
        head.getRight().setLeft(new Node(8));
        head.getRight().setRight(new Node(10));
        head.getLeft().setLeft(new Node(5));
        head.getLeft().setRight(new Node(6));

        boolean bst = isBst(head);
        System.out.println(bst);
    }
    private static Integer preValue = Integer.MIN_VALUE;

    /**
     * ÅÐ¶ÏÊÇ·ñÊÇ¶þ²æËÑË÷Ê÷
     * @param head
     * @return
     */
    public static boolean isBst(Node head){

        if (head == null){
            return true;
        }
        boolean isLefBst = isBst(head.getLeft());
        if (!isLefBst){
            return false;
        }
        if (head.getValue() < preValue){
            return false;
        }else {
            preValue = head.getValue();
        }
        return isBst(head.getRight());
    }
}
