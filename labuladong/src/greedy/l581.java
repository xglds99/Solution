package greedy;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/29 12:12
 */
public class l581 {

        public int findUnsortedSubarray(int[] nums) {
            if (isSorted(nums)) return 0;
            int n = nums.length;
            int []sortedNums = new int[n];
            System.arraycopy(nums, 0, sortedNums, 0,n);
            Arrays.sort(sortedNums);
            int r = n - 1;
            int l = 0;
            while(l < n && nums[l] == sortedNums[l]){
                l++;
            }
            while (r > 0 && nums[r] == sortedNums[r]){
                r--;
            }
            return r - l + 1;
        }

        public boolean isSorted(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }


}
