package binarysearch;

import org.junit.Test;

/**
 * @author xgl
 * @date 2023/5/4 22:38
 */
public class l2106 {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int res = 0;
        int n = fruits.length;
        int [] preSufix = new int [n + 1];
        int []ids = new int[n];
        for(int i = 0; i < n; i ++){
            preSufix[i + 1] = preSufix[i] + fruits[i][1];
            System.out.println(preSufix[i + 1]);
            ids[i] = fruits[i][0];
        }

        for(int x = 0; x <= k / 2; x++){
            int y = k - 2 * x;
            int left = startPos - x;
            int right = startPos + y;
            int start = left_bound(ids, left);
            int end = right_bound(ids, right);
            res = Math.max(res, preSufix[end] - preSufix[start]);
            y = k - 2 * x;
            left = startPos - y ;
            right = startPos + x;
            start = left_bound(ids, left);
            end = right_bound(ids, right);
            res = Math.max(res, preSufix[end] - preSufix[start]);
        }
        return res;
    }

    public int left_bound(int []nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] >= target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }


    public int right_bound(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] <= target){
                l = mid + 1;
            }else{
                r = mid -  1;
            }
        }
        if(r < 0) return 0;
        if(nums[r] <= target) return r + 1;
        return r;
    }

    @Test
    public  void test(){
        int [][] fruits = new int[][]{{2,8},{6,3},{8,6}};
        maxTotalFruits(fruits, 5, 4);

    }
//    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
//        int n = fruits.length;
//
//        int[] sum = new int[n + 10];
//        int[] indices = new int[n + 10];
//
//        sum[0] = 0;
//        for (int i = 0; i < n; i++) {
//            sum[i + 1] = sum[i] + fruits[i][1];
//            indices[i] = fruits[i][0];
//        }
//
//        int ans = 0;
//        for (int x = 0; x <= k / 2; x++) {
//            int y = k - 2 * x;
//            int left = startPos - x;
//            int right = startPos + y;
//            int start = lowerBound(indices, 0, n - 1, left);
//            int end = upperBound(indices, 0, n - 1, right);
//            ans = Math.max(ans, sum[end] - sum[start]);
//            /* 向右走 x 步，再向左走 k - x 步 */
//            y = k - 2 * x;
//            left = startPos - y;
//            right = startPos + x;
//            start = lowerBound(indices, 0, n - 1, left);
//            end = upperBound(indices, 0, n - 1, right);
//            ans = Math.max(ans, sum[end] - sum[start]);
//        }
//        return ans;
//    }
//
//    public int lowerBound(int[] arr, int left, int right, int val) {
//        int res = right + 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] >= val) {
//                res = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return res;
//    }
//
//    public int upperBound(int[] arr, int left, int right, int val) {
//        int res = right + 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] > val) {
//                res = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return res;
//    }
}

