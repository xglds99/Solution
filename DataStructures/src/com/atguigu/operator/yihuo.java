package com.atguigu.operator;

public class yihuo {
    public static void main(String[] args) {
        findDouble(new int[]{1, 1, 2, 4, 4});
        int a = 3;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ":" + b);
    }

    public static void findDouble(int[] nums) {
        int resu = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resu ^= nums[i];
        }
        System.out.println(resu);
    }
}
