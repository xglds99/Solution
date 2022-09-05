import java.util.ArrayDeque;
import java.util.Deque;

public class l946validateStackSequences {

    public boolean validateStackSequences(int []pushed, int []poped){
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0,j=0; i< pushed.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == poped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,4};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        swap(nums, 0, 2);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
