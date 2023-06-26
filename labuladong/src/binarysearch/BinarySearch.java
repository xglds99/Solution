package binarysearch;

import java.util.HashMap;

public class BinarySearch {

    /**
     * Ѱ��ָ��Ԫ�أ��ҵ������±꣬�Ҳ�������-1��
     *
     * @param nums
     * @param target
     * @return
     */
    HashMap<Integer, Integer> map = new HashMap<>();

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
     *�ҵ�һ��>=x����
     * ����ת���� >x, <= x, < x
     * >x ===> �� >=(x + 1)
     * < x ===> �� >=(x) -1
     * <=x === > �� >x -1 ==> >=(x + 1) -1
     * @param nums
     * @param target
     * @return
     */

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // �𷵻أ��������߽�
                right = mid - 1;
            }
        }
        // �ж� target �Ƿ������ nums ��
        // ��ʱ target �����������󣬷��� -1
        if (left == nums.length) return -1;
        // �ж�һ�� nums[left] �ǲ��� target
        return nums[left] == target ? left : -1;
    }

    int left_bound(int[] nums, int target ,int l, int r) {
        int left = l, right = r;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // �𷵻أ��������߽�
                right = mid - 1;
            }
        }
        // �ж� target �Ƿ������ nums ��
        // ��ʱ target �����������󣬷��� -1
        if (left == nums.length) return -1;
        // �ж�һ�� nums[left] �ǲ��� target
        return nums[left] == target ? left : -1;
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
            } else if (nums[mid] == target) {
                // ����ĳ��������߽缴��
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // �����Ϊ��� right Խ������������ͼ
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }


    /**
     * @return int
     * @Author xgl
     * @Description Ѱ������һ�����ֵ�Ԫ�أ����߽磬
     * ����ҿ�����[ left, right);
     * @Date 10:33 2023/6/2
     * @Param [nums, target]
     **/
    public int left_bound_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int right_bound_2(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 8, 9, 11, 15, 58};
        int i = new BinarySearch().binarySearchLeftMax(arr, 57);
        System.out.println(i);
    }

    public int binarySearchLeftMax(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
