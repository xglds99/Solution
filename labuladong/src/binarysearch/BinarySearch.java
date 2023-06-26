package binarysearch;

import java.util.HashMap;

public class BinarySearch {

    /**
     * 寻到指定元素，找到返回下标，找不到返回-1；
     *
     * @param nums
     * @param target
     * @return
     */
    HashMap<Integer, Integer> map = new HashMap<>();

    int binarySearch_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }


    /**
     * 寻找左侧边界
     *找第一个>=x的数
     * 可以转换求 >x, <= x, < x
     * >x ===> 求 >=(x + 1)
     * < x ===> 求 >=(x) -1
     * <=x === > 求 >x -1 ==> >=(x + 1) -1
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
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
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
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    /**
     * 寻找右侧边界，左闭右闭区间，
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
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }


    /**
     * @return int
     * @Author xgl
     * @Description 寻找左侧第一个出现的元素，左侧边界，
     * 左闭右开区间[ left, right);
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
