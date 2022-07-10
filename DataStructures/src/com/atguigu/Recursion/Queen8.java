package com.atguigu.Recursion;

public class Queen8 {
    //定义一个max，表示有多少个皇后
    int max = 8;
    int array[] = new int[max];
    static  int count;
    static int judgecount;
    public static void main(String[] args) {

        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种情况！",count);
        System.out.printf("共判断%d次",judgecount);

    }
    public void check(int n){
        if(n  == max){
            print();
            return;
        }
        //依次放入皇后，并判断
        for (int i = 0 ; i < max; i++) {
            //先把当前皇后n，放到该行的第1列；
            array[n]=i;
            if(judge(n)){
                //不冲突，接着放第n+1个皇后，即开始递归
                check(n+1);
            }
        }
    }

    /**
     * 说明：
     * 1、array[i]判断第n个皇后是否和前面n-1个皇后在同一列
     * 2、Math.abs(n-i) == Math.abs(array[n]-array[n-1])判断第n个皇后是否和第i个皇后是否同一斜线
     * 3、n=1，放置在第2列
     * @param n
     * @return//查看放置第n个皇后的时候，是否与前n-1个冲突
     */
    public boolean judge(int n){
        judgecount++;
        for (int i = 0; i < n; i++) {
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        count++;
        System.out.println();
    }
}
