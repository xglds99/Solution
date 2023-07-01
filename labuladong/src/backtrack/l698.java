package backtrack;

/**
 * @author xgl
 * @date 2023/7/1 15:59
 */
public class l698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;
        // 穷举，看看 num s 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    // 递归穷举 nums 中的每个数字
    boolean backtrack(
            int[] nums, int index, int[] bucket, int target) {

        if (index == nums.length){
            for (int b : bucket){
                if (b != target) return false;
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }

}
