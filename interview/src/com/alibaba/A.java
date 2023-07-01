package com.alibaba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/27 10:16
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int A[][] =new int[n][2];

            for (int j = 0; j < n; j++) {
                A[j][0] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
               A[j][1] = sc.nextInt();
            }
            Arrays.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int res = 1;
            int xi = A[0][0];
            int yi = A[0][1];
            for (int j = 1; j < n; j++) {
                if (A[j][0] > xi && A[j][1] > yi){
                    res++;
                    xi = A[j][0];
                    yi = A[j][1];
                }
            }
            System.out.println(res);
        }
    }
}
