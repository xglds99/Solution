package monotonousstack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class nextdailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n  = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int []ans = new int[n];
        for(int i = n -1; i>=0;i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            System.out.println(temperatures[i] + " " + stack.isEmpty());
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void test(){
        int [] temperatures = new int[]{30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

    }
}
