package binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName l658
 * @Description
 * @Author xgl
 * @Date 2023/7/21 19:36
 * @Version 1.0
 */
public class l658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int r = binarySearch(arr, x);
        int l = r - 1;
        while(r - l + 1 < k){
            if ( l >= 0 && x - arr[l] <= arr[r] - x){
                l--;
            }else{
                r++;
            }
        }
        List<Integer> res = new ArrayList<>();
         for (int i = l + 1; i <= l + k - 1; i++) {
            res.add(arr[i]);
        }
         return res;
    }

    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l == arr.length ? r : l;
    }
}
