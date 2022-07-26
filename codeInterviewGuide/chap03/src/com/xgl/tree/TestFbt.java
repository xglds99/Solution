package com.xgl.tree;

public class TestFbt {

    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(7);
        head.setLeft(new Node(4));
        head.setRight(new Node(9));
        head.getRight().setLeft(new Node(8));
        head.getRight().setRight(new Node(10));
        head.getLeft().setLeft(new Node(2));

        boolean bst = isFbt(head);
        System.out.println(bst);
    }



    public static boolean isFbt(Node head){
        int height = process(head).height;
        int nodes = process(head).nodes;
        return Math.pow(2, height) - 1 == nodes;
        }


    public static returnData process(Node head){
        if (head == null){
            return new returnData(0, 0);
        }
        returnData leftData = process(head.getLeft());
        returnData rightData = process(head.getRight());

        int height  = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return  new returnData(height, nodes);
     }


    public static class returnData{
        int height;
        int nodes;

        public returnData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
}
