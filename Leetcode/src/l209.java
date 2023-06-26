/**
 * @ClassName l209
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 10:14
 * @Version 1.0
 */
public class l209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int cur = 0;
        int n = nums.length;
        int res = n + 1;
        while(i < n && j < n){
            cur+= nums[i];
            while(j < n && cur >= target){
                res = Math.min(i - j + 1,res);
                cur -= nums[j];
                j++;
            }
            i++;
        }
        return res == n + 1 ? 0 : res;
    }
}
