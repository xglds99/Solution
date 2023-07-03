import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName l2763
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 16:50
 * @Version 1.0
 */
public class l2763 {
//    public int sumImbalanceNumbers(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            HashSet<Integer> set = new HashSet<>(Set.of(nums[i]));
//            for (int j = i + 1, count = 0; j < nums.length; j++) {
//                sum += count += set.add(nums[j]) ? set.contains(nums[j] - 1) && set.contains(nums[j] + 1) ? -1
//                        : !set.contains(nums[j] - 1) && !set.contains(nums[j] + 1) ? 1 : 0 : 0;
//            }
//        }
//        return sum;
//    }

    static class Solution {
        public int sumImbalanceNumbers(int[] nums) {
            int n = nums.length;
            var right = new int[n];
            var idx = new int[n + 1];
            Arrays.fill(idx, n);
            for (int i = n - 1; i >= 0; i--) {
                int x = nums[i];
                // right[i] 表示 nums[i] 右侧的 x 和 x-1 的最近下标（不存在时为 n）
                right[i] = Math.min(idx[x], idx[x - 1]);
                idx[x] = i;
            }

            int ans = 0;
            Arrays.fill(idx, -1);
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                // 统计 x 能产生多少贡献
                ans += (i - idx[x - 1]) * (right[i] - i); // 子数组左端点个数 * 子数组右端点个数
                idx[x] = i;
            }
            // 上面计算的时候，每个子数组的最小值必然可以作为贡献，而这是不合法的
            // 所以每个子数组都多算了 1 个不合法的贡献
            return ans - n * (n + 1) / 2;
        }
    }

}
