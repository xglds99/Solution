package com.huaewi1;

import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/26 15:27
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        int []map =  new int[501];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            map[nums[i]]++;
        }
        for (int i = 0; i < 501; i++) {
            if (map[i] >= 1){
                System.out.println(i);
            }
        }

    }
}
