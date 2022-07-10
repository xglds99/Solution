import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class l503NextGreatElements {

    @Test
    public void test() {
    int nums[]=new int[]{1,2,3,4,3};
        int[] resu = nextGreaterElements1(nums);
        for (int i = 0; i < resu.length; i++) {
            System.out.print(resu[i]+" ");
        }
    }
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }


    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int resu[] = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        boolean loop = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        resu[index] = -1;
        int j = 0;
        while (loop) {
            if (deque.isEmpty() || nums[deque.peek()] > nums[j % nums.length]) {
                deque.push(j % nums.length);
                j++;
            } else {
                while (!deque.isEmpty() && nums[deque.peek()] < nums[j % nums.length]) {
                    resu[deque.pop()] = nums[j % nums.length];
                }
                deque.push(j % nums.length);
                j++;
            }
            if (nums[j % nums.length] == max) {
                resu[j % nums.length] = -1;
            }
            if (j >= index + nums.length +1) {
                loop = false;
            }
        }
        return resu;
    }
}

