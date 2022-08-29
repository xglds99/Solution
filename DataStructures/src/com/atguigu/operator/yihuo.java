package com.atguigu.operator;

public class yihuo {
    public static void main(String[] args) {
        findDouble(new int[]{1, 2, 3, 4, 5, 5});
        int a = 3;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ":" + b);
    }

    public static void findDouble(int[] nums) {
        int resu = 0;
        for (int i : nums) {
            resu = i ^ i;
        }
        System.out.println(resu);
    }
}
