package com.atguigu.sort;

import org.junit.Test;

/**
 * ��������: Java
 *
 * @author skywang
 * @date 2014/03/11
 */

public class QuickSort {

    /*
     * ��������
     *
     * ����˵��:
     *     a -- �����������
     *     l -- �������߽�(���磬����ʼλ�ÿ�ʼ������l=0)
     *     r -- ������ұ߽�(���磬�������������ĩβ����r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // ���������ҵ�һ��С��x����
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // ���������ҵ�һ������x����
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i-1); /* �ݹ���� */
            quickSort(a, i+1, r); /* �ݹ���� */
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {30,40,60,10,20,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}

