package com.atguigu.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSort {
    @Test
    public void ShellSortImplTest() {

        int nums[] = new int[]{8, 1, 6, 4, 3, 0, 5, 7, 9, 2};
        ShellSortImpl(nums);

    }

    public void ShellSortImpl1(int []arr){

        for (int gap=arr.length /2 ;gap >0 ;gap /=2){

        }

    }

    public void ShellSortImpl(int nums[]) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {//得到增量
            for (int i = gap; i < nums.length; i++) {
                for (int j = i- gap; j >= 0 ; j-= gap) {
                    int temp = 0;
                    if (nums[j] > nums[j + gap]) {
                        temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
