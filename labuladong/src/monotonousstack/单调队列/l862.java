package monotonousstack.单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName l862
 * @Description
 * @Author xgl
 * @Date 2023/7/21 14:04
 * @Version 1.0
 */
public class l862 {
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] preSumArr = new long[n + 1];
            for (int i = 0; i < n; i++) {
                preSumArr[i + 1] = preSumArr[i] + nums[i];
            }
            int res = n + 1;
            Deque<Integer> queue = new ArrayDeque<Integer>();
            for (int i = 0; i <= n; i++) {
                long curSum = preSumArr[i];
                while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                    res = Math.min(res, i - queue.pollFirst());
                }
                while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
            return res < n + 1 ? res : -1;
        }
    }
}
