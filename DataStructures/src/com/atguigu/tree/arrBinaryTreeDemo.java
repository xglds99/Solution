package com.atguigu.tree;



public class arrBinaryTreeDemo {
    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,4,5,6,7};
        arrBinaryTress arrBinaryTress=new arrBinaryTress(arr);
        arrBinaryTress.preOrder(0);
    }
}

class arrBinaryTress{
//    顺序二叉树通常只考虑完全二叉树
//    第n个元素的左子节点为  2 * n + 1
//    第n个元素的右子节点为  2 * n + 2
//    第n个元素的父节点为  (n-1) / 2

    public arrBinaryTress(int[] arr) {
        this.arr = arr;
    }




    int []arr;
    public void  preOrder(int index){
        if(arr==null || arr.length==0){
            System.out.println("！！！！！！");
        }
        System.out.println(arr[index]);
        if((2*index +1)<arr.length){
            preOrder(2*index +1);
        }
        if((2* index +2) <arr.length){
            preOrder(2 * index +2);
        }
    }
}