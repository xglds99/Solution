import org.junit.Test;

import java.util.TreeSet;

public class l239maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }
        res[index++] = set.last();
        for (int i = k; i < n; i++) {
            set.add(nums[i]);
            set.remove(nums[i - k]);
            res[index++] = set.last();
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
