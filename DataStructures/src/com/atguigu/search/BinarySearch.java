package com.atguigu.search;

public class BinarySearch {


    public  int  binarySearchImpl(int []nums,int target){
        int l = 0;
        int r = nums.length;
        int mid = -1;
        while (l <= r){
             mid = l + (r - l)/ 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
