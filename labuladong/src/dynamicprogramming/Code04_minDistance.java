package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code04_minDistance {

    int minDistance_1(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // i��j ��ʼ��ָ�����һ������
        return dp_1(s1, m - 1, s2, n - 1);
    }

    // ���壺���� s1[0..i] �� s2[0..j] ����С�༭����
    int dp_1(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp_1(s1, i - 1, s2, j - 1); // ɶ������
        }
        return min(
                dp_1(s1, i, s2, j - 1) + 1,    // ����
                dp_1(s1, i - 1, s2, j) + 1,    // ɾ��
                dp_1(s1, i - 1, s2, j - 1) + 1 // �滻
        );
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    //************************************************************************
    //ʹ�ñ���¼��¼�ص�������Ĵ𰸣������ظ������Խ���ʱ�临�Ӷ�
    int[][] dp;

    //ʹ��dp[i][j]����¼s1[0...i] s2[0...j]����̱༭����
    int minDistance_2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp_2(s1, m -1, s2, n - 1);
    }

    int dp_2(String s1, int i, String s2, int j) {
        //base case �ݹ�����ĵط�
        //��� ��s1 ��iƥ�����ˣ�s2��j��ûƥ���꣬˵�� s2����Ԫ��δ��s1ƥ�䣬���Խ�s2ʣ�µ�Ԫ��ȫ�����뵽s1��������Ҫ j +1��
        //ͬ��s2��jƥ�����ˣ�s1��i��δƥ���꣬˵��s1��ʣ��Ԫ�ض��࣬��Ҫ��s1ʣ�µ�Ԫ��ɾ����������Ҫ i + 1��
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = dp_2(s1, i - 1, s2, j - 1);
        else {
            dp[i][j] = min(dp_2(s1, i, s2, j - 1) + 1, //s1����һ��Ԫ�أ�i���䣬j��ǰ�ƶ���iƥ����һ��j
                    dp_2(s1, i - 1, s2, j) + 1, //s1ɾ��һ��Ԫ�أ�i��ǰƥ�䣬j����
                    dp_2(s1, i - 1, s2, j - 1) + 1);//s1�滻һ��Ԫ�أ�i������ǰ-1ƥ�� ��j������ǰ-1ƥ��
        }
        return dp[i][j];
    }

    int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        //s1��Ҫƥ����ַ������� 0....m-1   s2��Ҫƥ����ַ������� 0....n-1
        // ���壺s1[0..i] �� s2[0..j] ����С�༭������ dp[i+1][j+1]
        // ���壺s1[0..i-1] �� s2[0..j-1] ����С�༭������ dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // �Ե��������
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1, // ɾ��
                            dp[i][j - 1] + 1, // ����
                            dp[i - 1][j - 1] + 1 //�滻
                    );
                }
            }
        }
        // ���������� s1 �� s2 ����С�༭����
        return dp[m][n];
    }

   @Test
    public void test(){
       int i = minDistance("rad", "apple");
       System.out.println(i);
   }


}
