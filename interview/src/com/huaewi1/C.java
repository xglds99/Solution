package com.huaewi1;

import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/26 15:31
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = Integer.parseInt(s.substring(2).toLowerCase(),16);
        System.out.println(i);
    }
}
