package com.atguigu.Recursion;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(test(3));
    }

    public static  int  test(int n){
        if(n>1){
         return    n*test(n-1);
        }else {
            return 1;
        }
    }
}
