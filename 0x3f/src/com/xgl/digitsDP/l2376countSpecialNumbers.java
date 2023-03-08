package com.xgl.digitsDP;

import org.junit.Test;

import java.util.Arrays;

public class l2376countSpecialNumbers {

    char[] s;
    int[][] dp;

    /**
     * ���һ��������ÿһ����λ���� ������ͬ�ģ����ǳ����� �������� ��
     * ͳ�ơ�1��n����������������ĸ���
     * @param n
     * @return
     */
    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        var m = s.length;
        dp = new int[m][1 << 10]; //dp���鶨�壬�ڵ�ǰi��λ��ѡ������ּ���mask������dp[i][mask]������
        for (var i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true, false);
    }

    /**
     *
     * @param i ����һ����λ��
     * @param mask ��¼֮ǰ��λѡ�������
     * @param isLimit ��ʾǰ��������Ƿ���n��Ӧλ�ϵģ����Ϊtrue����ô��ǰλ����Ϊs[i]����������9
     * @param isNum ��ʾǰ���Ƿ��������֣����Ϊtrue����ô��ǰλ���Դ�0��ʼ�����Ϊfalse�������������ǰλ������ߴ�1��ʼ�����֡�
     * Ϊʲôֻ��Ҫ��¼!isLimit && isNum�Ľ���أ�
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
            dp[i][mask] = res;// ���ʣ� ��ʲô�����ǲ����Ƶ�ʱ���¼�����

        return res;
    }

    @Test
    public void test(){
        countSpecialNumbers(9999);
    }
}
