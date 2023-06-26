package com.meituan2021_10;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,x,y;
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int [] socres = new int[n];
        int i = 0;
        while (sc.hasNext()){
            socres[i++] = sc.nextInt();
        }
        Arrays.sort(socres);
        int m = -1;
        for (int j = 0; j < n; j++) {
            int k = n - j - 1;
            int o = n - k;
            if (k >= x && k <= y && o >=x && o<= y){
                m = socres[j];
                break;
            }
        }
        System.out.println(m);
    }
}
