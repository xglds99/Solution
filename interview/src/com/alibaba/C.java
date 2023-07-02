package com.alibaba;

import com.xgl.class06.Code03_AddMinusMultiDivideByBit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName C
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/2 14:50
 * @Version 1.0
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mod= (int)1e9 + 7;
        long [][]dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = (dp[i][j] + (dp[k][j-1]* dp[i-k-1][j-1])) % mod;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
