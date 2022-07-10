import java.util.Arrays;

public class l16threeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int taret = 1;
        int i = threeSumClosest(nums, taret);
        System.out.println(i);

    }
/*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

    返回这三个数的和。

    假定每组输入只存在恰好一个解*/

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = Integer.MAX_VALUE;
        //枚举a
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //使用双指针枚举b和c
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
            int sum = nums[i] + nums[j] +nums[k];
            if (sum == target){
                return target;
            }
            //根据差值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if (sum > target){
                    int k0 = k -1;
                    while (j <k0 && nums[k0] == nums[k]){
                        k0--;
                    }
                    k = k0;
                }else {
                    int j0 = j+1;
                    while (j0 < k && nums[j]==nums[j+1]){
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return  best;
    }
}
