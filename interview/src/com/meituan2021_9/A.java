package com.meituan2021_9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName A
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/23 20:10
 * @Version 1.0
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] w = new int[m];
            for (int i = 0; i < m; i++) {
                w[i] = sc.nextInt();
            }
            if(a>b){ //保证a小b大
                a=a+b;
                b=a-b;
                a=a-b;
            }
            Arrays.sort(w);
            int res = 2;
            if (w[0] < a || w[m - 1] > b){
                System.out.println("NO");
                continue;
            }
            if (w[0] == a) res--;
            if (w[m - 1] == b) res--;
            if (res == 0) {
                System.out.println("YES");
                continue;
            }
            if (n - m >= res) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");

        }
    }
}
