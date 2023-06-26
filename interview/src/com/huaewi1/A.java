package com.huaewi1;

import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/26 15:23
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while((n = sc.nextInt()) != 0){
            int res = 0;
            while(n >= 3){
                n -= 3;
                res++;
                n += 1;
            }
            if (n == 2)res++;
            System.out.println(res);
        }
    }
}
