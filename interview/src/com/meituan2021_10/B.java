package com.meituan2021_10;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(i + 1 - nums[i]);
        }
        System.out.println(res);
    }
}
