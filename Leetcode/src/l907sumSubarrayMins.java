import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class l907sumSubarrayMins {

    public int sumSubarrayMins(int[] arr) {
        int Mod = (int)1e9 + 7;
        int n = arr.length;
        int []left = new int[n];
        int []right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while(stack.size() > 1 && arr[stack.peek()] >= arr[i]){
                //当找左侧第一个小于当前元素的值的时候，因为栈是单调递增，如果栈顶元素大于等于当前元素的时候，那就要出栈
                //那么出栈的元素呢，其右侧第一个小于等于出栈元素的值就是当前元素。
                //相当于当前的出栈的元素的右侧第一个小于等于的值就是当前元素。
                right[stack.pop()] = i;
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        long res = 0L;
        for (int i = 0; i < n; i++) {
            //根据乘法原理，左侧元素的个数 * 右侧元素的个数 = 贡献的总次数。
            res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % Mod;
        }
        return (int)res;
    }
}
