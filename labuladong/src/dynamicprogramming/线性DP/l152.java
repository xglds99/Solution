package dynamicprogramming.线性DP;

/**
 * @ClassName l152
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 8:59
 * @Version 1.0
 */
public class l152 {
    /**
     * 不能想最大子数组和一样，不满足当前位置的最优解可以由前一个位置转移得到
     * 要想得到当前位置的最大值，需要和前一个位置的最小值， 进行比较
     * 考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
     * 并且我们希望这个积尽可能「负得更多」，即尽可能小。
     * 如果当前位置是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
     * 它表示以第 i 个元素结尾的乘积最小子数组的乘积，那么我们可以得到这样的动态规划转移方程：
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        System.arraycopy(nums, 0, minDp, 0, n);
        System.arraycopy(nums, 0, maxDp, 0, n);
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(maxDp[i - 1] * nums[i], nums[i]));
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
