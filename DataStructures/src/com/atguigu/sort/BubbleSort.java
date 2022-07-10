package com.atguigu.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {

    }
    @Test
    public void test() {
        int nums[] = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            nums[i]= (int) (Math.random() * 80000);
        }
        Date start = new Date(System.currentTimeMillis());
        BubbleSortImpl(nums);
        Date end=new Date(System.currentTimeMillis());
        System.out.println(end.getTime() - start.getTime());
    }

    public void BubbleSortImpl(int[] nums) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                System.out.println("ÅÅĞòÍê³É£¡");
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
