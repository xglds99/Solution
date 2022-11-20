package com.xgl.digitsDP;

import org.junit.Test;

import java.util.Arrays;

public class l233countDigitOne {
    char s[];
    int dp[][];

    /**
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        var m = s.length;
        dp = new int[m][m];
        for (var i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    /**
     *
     * @param i ������λ
     * @param cnt1 ����1�ĸ�����
     * @param isLimit
     * @return
     */
    int f(int i, int cnt1, boolean isLimit) {
        if (i == s.length) return cnt1;
        if (!isLimit && dp[i][cnt1] >= 0){
            System.out.println("dp[i][cnt1] = " + dp[i][cnt1] + "i = " + i + "  " + " cnt1 = " + cnt1);
            return dp[i][cnt1];
        }
        var res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) // ö��Ҫ��������� d
            res += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        if (!isLimit) dp[i][cnt1] = res;
        return res;
    }

    @Test
    public void test(){
        countDigitOne(9999);
    }
}
