package com.tencent2021;

import java.util.Scanner;

/**
 * @ClassName A
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 13:51
 * @Version 1.0
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        int cnt0 =0 , cnt1 = 0;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(char c: cs){
            if (c == '0') {
                cnt0++;
                s1.append("0");
            }
            else {
                cnt1++;
                s2.append("1");
            }
        }

        int res1 = ((1 + cnt0) * cnt0) / 2;
        int res2 = ((1 + cnt1) * cnt1) / 2;
        System.out.println(s.contains(s1));
        System.out.println(s.contains(s2));
        if (cnt0 <= cnt1)
            if (cnt0 != n && !s.contains(s1))res2++;
        else{
            if (cnt1 != n && !s.contains(s2))res1++;
        }
        int [] f = new int[n + 1];
        f[1] = 1;
        int res = f[1];
        for (int i = 2; i <= n ; i++) {
            if (s.charAt(i - 1) == s.charAt(i - 2)){
                f[i] = f[i - 1] + 1;
            }else{
                f[i] = 1;
            }
            res += f[i];
        }
        int ans = Math.max(res, Math.max(res1, res2));
        System.out.println(ans);
    }
}
