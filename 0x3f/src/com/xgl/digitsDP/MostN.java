package com.xgl.digitsDP;

import java.util.Arrays;

public class MostN {

    private String[] digits;
    private char s[];
    private int dp[];

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length];
        Arrays.fill(dp, -1); // dp[i] = -1 ��ʾ i ���״̬��û���������
        return f(0, true, false);
    }

    private int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) return isNum ? 1 : 0; // ����������֣���Ϊ 1 �ֺϷ�����
        if (!isLimit && isNum && dp[i] >= 0) return dp[i]; // �ڲ��ܵ��κ�Լ��������£����ؼ�¼�Ľ���������ظ�����
        var res = 0;
        if (!isNum) // ǰ�治�����֣���ô����������ǰ��λ��Ҳ��������
            // isLimit ��Ϊ false����Ϊû�������֣�λ������ n Ҫ�̣���Ȼ�����ܵ� n ��Լ��
            // isNum ��ȻΪ false����Ϊû�����κ�����
            res = f(i + 1, false, false);
        var up = isLimit ? s[i] : '9'; // �����Ƿ��ܵ�Լ������������������ֵ�����
        // ע�⣺����һ�����Ŀ���ԣ������ʱ isNum Ϊ false�������� 1 ��ʼö�٣����ڱ��� digits û�� 0���������账���������
        for (var d : digits) { // ö��Ҫ��������� d
            if (d.charAt(0) > up) break; // d �������ޣ����� digits ������ģ������ d ���ᳬ�����ޣ����˳�ѭ��
            // isLimit�������ǰ�ܵ� n ��Լ������������ֵ������ޣ���ô������Ȼ���ܵ� n ��Լ��
            // isNum Ϊ true����Ϊ��������
            res += f(i + 1, isLimit && d.charAt(0) == up, true);
        }
        if (!isLimit && isNum) dp[i] = res; // �ڲ��ܵ��κ�Լ��������£���¼���
        return res;
    }

}
