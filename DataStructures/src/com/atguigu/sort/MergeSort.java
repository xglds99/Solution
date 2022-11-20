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
        int i = left; // ��ʼ��i, ����������еĳ�ʼ����
        int j = mid + 1; //��ʼ��j, �ұ��������еĳ�ʼ����
        int t = 0; // ָ��temp����ĵ�ǰ����

        //(һ)
        //�Ȱ���������(����)�����ݰ��չ�����䵽temp����
        //ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
        while (i <= mid && j <= right) {//����
            //�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
            //������ߵĵ�ǰԪ�أ���䵽 temp���� 
            //Ȼ�� t++, i++
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                t += 1;
                i += 1;
            } else { //��֮,���ұ��������еĵ�ǰԪ�أ���䵽temp����
                temp[t] = nums[j];
                t += 1;
                j += 1;
            }
        }
        //(��)
        //����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
        while (i <= mid) { //��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
            temp[t] = nums[i];
            t += 1;
            i += 1;
        }

        while (j <= right) { //�ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
            temp[t] = nums[j];
            t += 1;
            j += 1;
        }

        //(��)
        //��temp�����Ԫ�ؿ�����nums
        //ע�⣬������ÿ�ζ���������
        t = 0;
        int tempLeft = left; // 
        //��һ�κϲ� tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //���һ�� tempLeft = 0  right = 7
        while (tempLeft <= right) {
            nums[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
