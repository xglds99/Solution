package com.baidu1;

import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/26 22:52
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n =  sc.nextInt();
            long res = (long) n * (n - 1)  - 1;
            System.out.println(res);
        }
    }


    private static int gcd(int a, int b) {
        if (b == 0)return a;
        return gcd(b, a % b);
    }
}
