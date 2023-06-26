package com.meituan2021_10;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1][i] = arr[i] * arr[i + 1];
            dp[i][i + 1][i + 1] = dp[i][i + 1][i];
        }
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                for (int m = i; m <= i + k; m++) {
                    int left = i == m ? 0 : dp[i][m - 1][i] + arr[i] * arr[m];
                    for (int l = i + 1; l < m; l++) {
                        left = Math.min(left, dp[i][m - 1][l] + arr[l] * arr[m]);
                    }
                    int right = m == i + k ? 0 : dp[m + 1][i + k][i + k] + arr[i + k] * arr[m];
                    for (int r = m + 1; r < i + k; r++) {
                        right = Math.min(right, dp[m + 1][i + k][r] + arr[r] * arr[m]);
                    }
                    dp[i][i + k][m] = left + right;
                }
            }
        }
        int res = dp[0][n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[0][n - 1][i]);
        }
        System.out.println(res);
    }

}
