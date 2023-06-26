/**
 * @ClassName l713
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 10:04
 * @Version 1.0
 */
public class l713 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = i; j < n; j++) {
                cur *= nums[j];
                if (cur < k)res++;
                else break;
            }
        }
        return res;
    }
    public int numSubarrayProductLessThanK_1(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int cur = 1;
        int res = 0;
        while(i < n && j < n){
            cur *= nums[i];
            while(j < n && cur >= k){
                cur /= nums[j];
                j++;
            }
            res += i - j + 1;
            i++;
        }
        return res;
    }
}
