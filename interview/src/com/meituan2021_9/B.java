package com.meituan2021_9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName B
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/23 20:29
 * @Version 1.0
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int []s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        Arrays.sort(s);
        if (s[n - 1] == 0){
            System.out.println(0);
            return;
        }
        int res = 0;
        int sx = s[n - x];
        for (int i = n - 1; i >= 0 ; i--) {
            if (s[i] >= sx && s[i] != 0)res++;
        }
        System.out.println(res);

    }
}
