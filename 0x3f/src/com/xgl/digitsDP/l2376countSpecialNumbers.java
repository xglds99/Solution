package com.xgl.digitsDP;

import org.junit.Test;

import java.util.Arrays;

public class l2376countSpecialNumbers {

    char[] s;
    int[][] dp;

    /**
     * 如果一个正整数每一个数位都是 互不相同的，我们称它是 特殊整数 。
     * 统计【1，n】区间的特殊整数的个数
     * @param n
     * @return
     */
    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        var m = s.length;
        dp = new int[m][1 << 10]; //dp数组定义，在当前i数位，选择的数字集合mask，共有dp[i][mask]个数。
        for (var i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true, false);
    }

    /**
     *
     * @param i 到哪一个数位了
     * @param mask 记录之前数位选择的数字
     * @param isLimit 表示前面的数字是否都是n对应位上的，如果为true，那么当前位至多为s[i]，否则至多9
     * @param isNum 表示前面是否填了数字，如果为true，那么当前位可以从0开始，如果为false，则可以跳过当前位不填，或者从1开始填数字。
     * 为什么只需要记录!isLimit && isNum的结果呢？
     * @return
     */
    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if(i == s.length)return  isNum ? 1 :0;
        if(!isLimit && isNum && dp[i][mask] >= 0){
            System.out.println("dp[i][mask] :" + dp[i][mask] + " i : " + i + " mask : " + mask);
            return dp[i][mask];
        }
        int res = 0;
        if(!isNum) res = f(i + 1, mask, false, false);
        for(int d = isNum ? 0 : 1, up = isLimit ? s[i] - '0' : 9; d <= up; ++d){
            if((mask & (1 << d)) == 0)
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        }
        if (!isLimit && isNum)
            dp[i][mask] = res;// 疑问？ 问什么必须是不限制的时候记录结果？

        return res;
    }

    @Test
    public void test(){
        countSpecialNumbers(9999);
    }
}
