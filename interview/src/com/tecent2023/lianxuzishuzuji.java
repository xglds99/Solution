package com.tecent2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/25 16:29
 */
public class lianxuzishuzuji {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型ArrayList
     * @param x int整型
     * @return int整型
     */
    private static int mod = (int) 1e9 + 7;
    public static int getSubarrayNum (List<Integer> a, int x) {
        // write code here
        // write code here
        int n = a.size();
        long res = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                long x1 = 1L;
                for(int m = j; m <= i; m++){
                    x1 = (x1 * a.get(m)) % mod;
                }
                if(getzero(x1) >= x){
                    res = (res + 1) % mod;
                }
            }
        }

        return (int)res % mod;
    }

    public static int getzero(long x){
        int cnt = 0;
        while(x != 0){
            int d =(int) x % 10;
            if(d == 0) cnt++;
            else return cnt;
            x /= 10;
        }
        return cnt;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 55, 49, 48, 38, 19, 82, 98, 36, 39, 95, 39, 24, 5, 83, 98, 11, 65, 14, 10, 16, 8, 19, 83, 98, 29, 16, 50, 57, 88, 59, 2, 60, 84, 97, 72, 40, 55, 81, 91, 23, 90, 46, 41, 5, 34, 14, 11, 13, 87, 86, 27, 19, 55, 50, 30, 67, 16, 51, 99, 50, 40, 66, 58, 94, 9, 78, 19, 25, 36, 83, 76, 26, 66, 25, 78, 54, 77, 36, 12, 46, 73, 51, 100, 76, 70, 44, 28, 8, 60, 29, 61, 16, 78, 14, 15, 22, 16, 15, 63, 8, 73);
        getSubarrayNum( list, 2);
    }
}
