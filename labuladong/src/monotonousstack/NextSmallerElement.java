package monotonousstack;

import java.util.Deque;
import java.util.LinkedList;

public class NextSmallerElement {

    public static void main(String[] args) {
        int []nums = new int[]{1,0,5,3,8,4};
        int[] res = getNextSmallElement(nums);
        for (int re : res) {
            System.out.println("re = " + re);
        }
    }
    public static int[] getNextSmallElement(int []nums){
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int []res = new int[n];
        for (int i = n -1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? - 1 : stack.peek();
            stack.push(nums[i]);
        }
        return  res;
    }
}
