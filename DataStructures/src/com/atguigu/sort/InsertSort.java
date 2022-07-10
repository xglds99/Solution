package com.atguigu.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    @Test
    public void InsertSortImplTest() {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 80000);
        }
        Date start = new Date(System.currentTimeMillis());
        InsertSortImpl(nums);
        Date end = new Date(System.currentTimeMillis());
        System.out.println("花费的时间：" + (end.getTime() - start.getTime()) + "ms");
    }
    public void InsertSortImpl( int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int insertVal = nums[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < nums[insertIndex]) {
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex + 1] = insertVal;
            System.out.printf("第%d趟排序后：", i);
            System.out.println(Arrays.toString(nums));
        }
    }
}
