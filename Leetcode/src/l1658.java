import java.util.Arrays;

public class l1658 {


    /**
     * 逆向思维 滑动窗口
     * 求最长子数组 subnums 的和 target = sum - x;
     * 需要的最少操作数 k = n - subnums.length;
     * 右指针循环从右开始加，如果和大于 target, 左指针向右移动
     * if sum == target 更新答案 res。注意此时求的是最长子数组的sum == target
     * 需要的最小操作数 k = n - res
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num :nums) target += num;
        if (target < 0) return  -1;
        int res = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++];
            if (sum == target) res = Math.max(res, right - left + 1);
        }
        return res < 0 ? -1 : n - res;
    }
}
