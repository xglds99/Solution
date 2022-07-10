public class l2104subArrayRanges {
    /*
    给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。

返回 nums 中 所有 子数组范围的 和 。

子数组是数组中一个连续 非空 的元素序列。

     */
    public static void main(String[] args) {
        int nums[]=new int[]{1,3,3};
        System.out.println(new l2104subArrayRanges().subArrayRanges(nums));
    }
/*
首先用双循环来遍历所有子数组，遍历的时候得到子数组的最大值与最小值，并计算最大值与最小值的差加入结果中。
 */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

}
