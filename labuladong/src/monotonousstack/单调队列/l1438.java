package monotonousstack.单调队列;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @ClassName l1438
 * @Description
 * @Author xgl
 * @Date 2023/7/21 14:28
 * @Version 1.0
 */
public class l1438 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]) maxQueue.pollLast();
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[i]) minQueue.pollLast();
            maxQueue.addLast(nums[i]);
            minQueue.addLast(nums[i]);
            while(!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if (nums[j] == maxQueue.peekFirst()) maxQueue.pollFirst();
                if (nums[j] == minQueue.peekFirst()) minQueue.pollFirst();
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int longestSubarray11(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;

    }
}
