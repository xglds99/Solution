import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class l239maxSlidingWindow {
//1,3,-1,-3,5,3,6,7], k = 3
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0,j = 0; i < n; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
            {
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            if(i + 1>= k){
                res[i+1-k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] ints = maxSlidingWindow(new int[]{-7, -8, 7, 5, 1, 6, 0}, 4);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
