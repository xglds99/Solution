package com.atguigu.sort;


import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    
    public void merge(int []nums, int r, int l){
        if (l==r)return;
        int mid = (l + r) >> 1;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        mergeSort(nums, l, r, mid);
    }
    
    public void mergeSort(int []nums,int left, int right, int mid){
        int []temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while(l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                temp[index++] = nums[l];
                l++;
            }else {
                temp[index++] = nums[r];
                r++;
            }
            while(l <= mid){
                temp[index++] = nums[l++];
            }
            while(r <= right){
                temp[index++] = nums[r++];
            }
            if (index >= 0) System.arraycopy(temp, 0, nums, left, index);
        }
        
    }
        


    public static void main(String[] args) {
        int[] nums = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[nums.length];

        mergeSortImpl(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }


    public static void mergeSortImpl(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortImpl(nums, left, mid, temp);
            mergeSortImpl(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    /**
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1; //初始化j, 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组 
            //然后 t++, i++
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                t += 1;
                i += 1;
            } else { //反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = nums[j];
                t += 1;
                j += 1;
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = nums[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = nums[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组的元素拷贝到nums
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left; // 
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (tempLeft <= right) {
            nums[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
