package com.alibaba;

import java.util.Scanner;

/**
 * @ClassName B
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/2 14:21
 * @Version 1.0
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD  = (int)1e9 + 7;
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if (n  == 1){
                System.out.println(2);
                continue;
            }
            long []nums = new long[n + 1];
            nums[0] = 2;
            nums[1] = a;
            for (int j = 2; j <= n; j++) {
                nums[j] = (((nums[j - 1] * a) % MOD  - (nums[j - 2] * b) % MOD) + MOD) % MOD;
            }
            System.out.println(nums[n]);
        }
    }
}
