package com.atguigu.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    @Test
    public void selectSortImplTest(){
        int nums[]=new int[80000];
        for (int i = 0; i < nums.length ;  i++) {
            nums[i] = (int) (Math.random() * 80000);
        }
        Date start=new Date(System.currentTimeMillis());
        System.out.println(start);
        System.out.println("排序后");
        SelectSortImpl(nums);
        Date end=new Date(System.currentTimeMillis());
        System.out.println(end);
        System.out.println("花费的时间："+ (end.getTime() - start.getTime()) + "ms");
    }

    public void SelectSortImpl(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }
}
