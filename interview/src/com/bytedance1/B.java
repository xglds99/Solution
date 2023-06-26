package com.bytedance1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName B
 * @Description
 *2.
 * 万万没想到之抓捕孔连顺
 * 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议
 *
 * 1. 我们在字节跳动大街的 N 个建筑中选定 3 个埋伏地点。
 * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过 D 。
 *
 * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
 * ……
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
 *
 * 请听题：给定 N（可选作为埋伏点的建筑物数）、 D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合( A , B , C ) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 *
 * 一句话总结
 * 确定第三个数的位置，从左边界到第三个位置中选择2个数进行组合
 * @Author xgl
 * @Date 2023/6/24 16:16
 * @Version 1.0
 */
public class B {
    public static long computeCombination(int n, int m){
        int mod = 99997867;
        if(m>n) return 0;
        if(m==n) return 1;
        if(m<0||n<0) return 0;
        int half_n = n / 2;
        if(m>half_n) m = n - m;
        long numerator=1,denominator=1;
        for (int i = 0; i < m; i++) {
            numerator =  (numerator * (n - i)) % mod;
            denominator = (denominator * (i + 1)) % mod;
        }
        return numerator / denominator;
    }
    public static void main(String[] args) throws IOException {
        int MOD = 99997867;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int []locate = new int[N];
        int i = 0;
        for (int j = 0; j < N; j++) {
            locate[j] = sc.nextInt();
        }
        int j = 0;
        long res = 0L;
        while(i < N && j < N){
            while(j < N && locate[i] - locate[j] > D){
                j++;
            }
            if (i - j + 1>= 3){
                res += (res + ((long) (i - j) *(i - j - 1) / 2) % MOD) %MOD;
            }
            i++;
        }
        System.out.println(res);
    }
}
