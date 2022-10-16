package com.atguigu.sort;

import java.util.PriorityQueue;


/**
 * ������: Java
 *
 * @author skywang
 * @date 2014/03/11
 */
 class HeapSort {

    /*
     * (���)�ѵ����µ����㷨
     *
     * ע: ����ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
     *     ���У�NΪ�����±�����ֵ���������е�1������Ӧ��NΪ0��
     *
     * ����˵��:
     *     a -- �����������
     *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
     *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
     */
    public static void maxHeapDown(int[] a, int start, int end) {
        int c = start;            // ��ǰ(current)�ڵ��λ��
        int l = 2*c + 1;        // ��(left)���ӵ�λ��
        int tmp = a[c];            // ��ǰ(current)�ڵ�Ĵ�С

        for (; l <= end; c=l,l=2*l+1) {
            // "l"�����ӣ�"l+1"���Һ���
            if ( l < end && a[l] < a[l+1])
                l++;        // ������������ѡ��ϴ��ߣ���m_heap[l+1]
            if (tmp >= a[l])
                break;        // ��������
            else {            // ����ֵ
                a[c] = a[l];
                a[l]= tmp;
            }
        }
    }

    /*
     * ������(��С����)
     *
     * ����˵��:
     *     a -- �����������
     *     n -- ����ĳ���
     */
    public static void heapSortAsc(int[] a, int n) {
        int i,tmp;

        // ��(n/2-1) --> 0��α���������֮�󣬵õ�������ʵ������һ��(���)����ѡ�
        for (i = n / 2 - 1; i >= 0; i--)
            maxHeapDown(a, i, n-1);

        // �����һ��Ԫ�ؿ�ʼ�����н��е��������ϵ���С�����ķ�Χֱ����һ��Ԫ��
        for (i = n - 1; i > 0; i--) {
            // ����a[0]��a[i]��������a[i]��a[0...i]�����ġ�
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // ����a[0...i-1]��ʹ��a[0...i-1]��Ȼ��һ�����ѡ�
            // ������֤a[i-1]��a[0...i-1]�е����ֵ��
            maxHeapDown(a, 0, i-1);
        }
    }

    /*
     * (��С)�ѵ����µ����㷨
     *
     * ע: ����ʵ�ֵĶ��У���N���ڵ�����ӵ�����ֵ��(2N+1)���Һ��ӵ�������(2N+2)��
     *     ���У�NΪ�����±�����ֵ���������е�1������Ӧ��NΪ0��
     *
     * ����˵��:
     *     a -- �����������
     *     start -- ���µ��ڵ����ʼλ��(һ��Ϊ0����ʾ�ӵ�1����ʼ)
     *     end   -- ������Χ(һ��Ϊ���������һ��Ԫ�ص�����)
     */
    public static void minHeapDown(int[] a, int start, int end) {
        int c = start;            // ��ǰ(current)�ڵ��λ��
        int l = 2*c + 1;        // ��(left)���ӵ�λ��
        int tmp = a[c];            // ��ǰ(current)�ڵ�Ĵ�С

        for (; l <= end; c=l,l=2*l+1) {
            // "l"�����ӣ�"l+1"���Һ���
            if ( l < end && a[l] > a[l+1])
                l++;        // ������������ѡ���С��
            if (tmp <= a[l])
                break;        // ��������
            else {            // ����ֵ
                a[c] = a[l];
                a[l]= tmp;
            }
        }
    }

    /*
     * ������(�Ӵ�С)
     *
     * ����˵��:
     *     a -- �����������
     *     n -- ����ĳ���
     */
    public static void heapSortDesc(int[] a, int n) {
        int i,tmp;

        // ��(n/2-1) --> 0��α���ÿ������֮�󣬵õ�������ʵ������һ����С�ѡ�
        for (i = n / 2 - 1; i >= 0; i--)
            minHeapDown(a, i, n-1);

        // �����һ��Ԫ�ؿ�ʼ�����н��е��������ϵ���С�����ķ�Χֱ����һ��Ԫ��
        for (i = n - 1; i > 0; i--) {
            // ����a[0]��a[i]��������a[i]��a[0...i]����С�ġ�
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // ����a[0...i-1]��ʹ��a[0...i-1]��Ȼ��һ����С�ѡ�
            // ������֤a[i-1]��a[0...i-1]�е���Сֵ��
            minHeapDown(a, 0, i-1);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSortAsc(a, a.length);            // ��������
        //heapSortDesc(a, a.length);        // ��������

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}

