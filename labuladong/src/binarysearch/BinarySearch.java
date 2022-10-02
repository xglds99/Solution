package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class BinarySearch {

    /**
     * Ѱ��ָ��Ԫ�أ��ҵ������±꣬�Ҳ�������-1��
     *
     * @param nums
     * @param target
     * @return
     */
    HashMap<Integer,Integer> map = new HashMap<>();
    int binarySearch_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // ע��

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // ע��
            else if (nums[mid] > target)
                right = mid - 1; // ע��
        }
        return -1;
    }



    /**
     * Ѱ�����߽�
     *
     * @param nums
     * @param target
     * @return
     */
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // ע��

        while (left < right) { // ע��
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // ע��
            }
        }
        return left;
    }

    /**
     * Ѱ���Ҳ�߽磬����ұ����䣬
     *
     * @param nums
     * @param target
     * @return
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // ����ĳ��������߽缴��
                left = mid + 1;
            }
        }
        // �����Ϊ��� right Խ������������ͼ
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
    }
}
