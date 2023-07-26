
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName l239
 * @Description
 * @Author xgl
 * @Date 2023/7/21 11:10
 * @Version 1.0
 */
public class l239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int []res=  new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            //保持一个从大到小的单调队列，小于当前元素的直接弹出
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            //去除不属于当前窗口的元素
            if (i - k >= queue.peekFirst()){
                queue.pollFirst();
            }
            //从第k个元素开始，记录答案
            if (i + 1 >= k){
                res[i + 1 - k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
//    if(nums == null || nums.length < 2) return nums;
//    // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
//    LinkedList<Integer> queue = new LinkedList();
//    // 结果数组
//    int[] result = new int[nums.length-k+1];
//    // 遍历nums数组
//        for(int i = 0;i < nums.length;i++){
//        // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
//        while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
//            queue.pollLast();
//        }
//        // 添加当前值对应的数组下标
//        queue.addLast(i);
//        // 判断当前队列中队首的值是否有效
//        if(queue.peek() <= i-k){
//            queue.poll();
//        }
//        // 当窗口长度为k时 保存当前窗口中最大值
//        if(i+1 >= k){
//            result[i+1-k] = nums[queue.peek()];
//        }
//    }
//        return result;
}
