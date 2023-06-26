package com.bytedance1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName B
 * @Description
 *2.
 * ����û�뵽֮ץ������˳
 * �ҽ����󴸣���һ���ع����Ҹոսӵ��������ֽ�������ֽ��������ץ���ֲ����ӿ���˳������һ���ж��Ļ������������ع���������
 *
 * 1. �������ֽ�������ֵ� N ��������ѡ�� 3 ������ص㡣
 * 2. Ϊ���໥��Ӧ�����Ǿ��������Զ�������ع���ľ��벻���� D ��
 *
 * �������Ǹ����! �������ܵļ��㣬���Ǵ�X�ֿ��е����������ѡ����һ�֡������������һʧ�������ɣ�����˳��
 * ����
 * ����û�뵽���ƻ�����ʧ���ˣ�����˳��ױ��С��Ů������cosplay�Ķ������ӳ����ֽ�������֡�ֻ������αװ̫�ɹ��ˣ����������������Ҳ���ֲ��˵ģ�
 *
 * �����⣺���� N����ѡ��Ϊ�����Ľ����������� D�������Զ�������ع���ľ�������ֵ���Լ���ѡ���������꣬����������ж��У��󴸵�С���ж��������ѡ��
 * ע�⣺
 * 1. �����ع����������ͬһ�ص�
 * 2. �����ع��ǵȼ۵ģ���ͬ����λ�����( A , B , C ) ֻ��һ������������������ع�֮�以��λ�á����ظ�ʹ��
 *
 * һ�仰�ܽ�
 * ȷ������������λ�ã�����߽絽������λ����ѡ��2�����������
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
