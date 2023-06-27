package com.baidu1;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author xgl
 * @date 2023/6/26 23:04
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String []nums = new String[n];
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLine();
            pq.add(nums[i]);
        }
        int t = n;
        int res = 0;
        while (!pq.isEmpty() && pq.peek().compareTo(String.valueOf(t)) > 0) {
            String cur = pq.poll();
//            cur -= n;
            pq.add(cur);
            res++;
            t++;
        }
        System.out.println(res);

    }
    private static String sub(String s, int n){
        char[] cs = s.toCharArray();
        char[] ns = String.valueOf(n).toCharArray();
        int k = 0;
        for (int i = ns.length - 1; i >= 0 ; i--) {
             int d = k + cs[i] - ns[i];
             cs[i] = (char) ( d % 10);
             k = d / 10;
        }

        return new String(cs);
    }
}
