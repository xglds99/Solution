package com.atguigu.sort;

import org.junit.Test;

/**
 * 快速排序: Java
 *
 * @author skywang
 * @date 2014/03/11
 */

public class QuickSort {
    /*
     * 快速排序
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     left -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     right -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort_1(int[] a, int left, int right) {

        if (left < right) {
            int i, j, x;
            i = left;
            j = right;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于等于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于等于x的数
                if (i < j)
                    a[j--] = a[i];

            }
            a[i] = x;
            quickSort(a, left, i - 1); /* 递归调用 */
            quickSort(a, i + 1, right); /* 递归调用 */
        }
    }


    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
        base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;//一次排序把大于 base的数放在右边
            while (i < j && nums[i] <= base) i++; //一次排序把小于base的数放在左边
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
        int[] a = { 30, 40, 60, 20, 10, 50,30};

//        System.out.print("before sort:");
//        for (i=0; i<a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.print("\n");

        quickSort_1(a, 0, a.length - 1);

//        System.out.print("after  sort:");
//        for (i=0; i<a.length; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.print("\n");
    }

    @Test
    public void test(){
        int []arr = new int[]{3,5,6,3,4,5,2,6,9,0};
        int p1 = 0;
        int p0 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 5){
                swap(arr, p1, i);
                p1++;
            }else if(arr[i] < 5){
                swap(arr, p0, i);
                if(p0 < p1){
                    swap(arr, p1, i);
                }
                p1++;
                p0++;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void printArray(int []nums){
        for(int x : nums){
            System.out.print(x  + "  ");
        }
        System.out.println();
    }
}

