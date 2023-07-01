import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/27 12:23
 */
public class l918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int []dpmx = new int[nums.length];
        int []dpmn = new int[nums.length];
        dpmx[0] = nums[0];
        dpmn[0] = nums[0];
        int res = -1000000;
        for (int i = 1; i < nums.length; i++) {
            dpmx[i] = Math.max(dpmx[i - 1], 0) + nums[i];
            dpmn[i] = Math.min(dpmn[i - 1] + nums[i], nums[i]);
            res = Math.max(res,Math.max(sum - dpmn[i], dpmx[i]));
        }
        return res;
    }
}
