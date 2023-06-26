package com.meituan2021_9;

import java.util.Scanner;

/**
 * @ClassName C
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/23 20:44
 * @Version 1.0
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (sc.hasNext()){
            int N = sc.nextInt();
            int []A= new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
                sum += A[i];
            }
            int res1 = A[0];
            int res2 = A[0];
            //求最小子数组和
            int []dp0 = new int[N + 1];
            int []dp1 = new int[N + 1];
            dp0[0] = A[0];
            for (int i = 1; i < N; i++) {
                dp0[i] = Math.min(dp0[i - 1] + A[i], A[i]);
                dp1[i] = Math.max(dp1[ i - 1] + A[i], A[i]);
                res1 = Math.min(res1, dp0[i]);
                res2 = Math.max(res2, dp1[i]);
            }
            System.out.println(Math.max(sum - res1,res2));
        }

    }
}
