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
                // right[i] ��ʾ nums[i] �Ҳ�� x �� x-1 ������±꣨������ʱΪ n��
                right[i] = Math.min(idx[x], idx[x - 1]);
                idx[x] = i;
            }

            int ans = 0;
            Arrays.fill(idx, -1);
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                // ͳ�� x �ܲ������ٹ���
                ans += (i - idx[x - 1]) * (right[i] - i); // ��������˵���� * �������Ҷ˵����
                idx[x] = i;
            }
            // ��������ʱ��ÿ�����������Сֵ��Ȼ������Ϊ���ף������ǲ��Ϸ���
            // ����ÿ�������鶼������ 1 �����Ϸ��Ĺ���
            return ans - n * (n + 1) / 2;
        }
    }

}
