package greedy;

import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/29 12:27
 */
public class l611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
