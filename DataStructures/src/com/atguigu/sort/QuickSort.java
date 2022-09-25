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
     *     left -- �������߽�(���磬����ʼλ�ÿ�ʼ������l=0)
     *     right -- ������ұ߽�(���磬�������������ĩβ����r=a.length-1)
     */
    public static void quickSort_1(int[] a, int left, int right) {

        if (left < right) {
            int i, j, x;

            i = left;
            j = right;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // ���������ҵ�һ��С��x����
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // ���������ҵ�һ������x����
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, left, i - 1); /* �ݹ���� */
            quickSort(a, i + 1, right); /* �ݹ���� */
        }
    }


    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
        base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }


    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 30, 40, 60, 20, 10, 50};

//        System.out.print("before sort:");
//        for (i=0; i<a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.print("\n");

        quickSort(a, 0, a.length - 1);

//        System.out.print("after  sort:");
//        for (i=0; i<a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.print("\n");
    }
}

