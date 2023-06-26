/**
 * @ClassName l238
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 9:32
 * @Version 1.0
 */
public class l238 {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []prefix = new int[n];
        int []suffix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n ; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0 ; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int []res =  new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
