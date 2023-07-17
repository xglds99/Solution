import java.util.Arrays;

/**
 * @ClassName l2779
 * @Description
 * @Author xgl
 * @Date 2023/7/17 11:07
 * @Version 1.0
 */
public class l2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0;
        int res = 0;
        for (; i < n; i++) {
            while (nums[i] - nums[j] > 2 * k) j++;
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
