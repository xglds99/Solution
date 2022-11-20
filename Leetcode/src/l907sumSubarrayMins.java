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
                //��������һ��С�ڵ�ǰԪ�ص�ֵ��ʱ����Ϊջ�ǵ������������ջ��Ԫ�ش��ڵ��ڵ�ǰԪ�ص�ʱ���Ǿ�Ҫ��ջ
                //��ô��ջ��Ԫ���أ����Ҳ��һ��С�ڵ��ڳ�ջԪ�ص�ֵ���ǵ�ǰԪ�ء�
                //�൱�ڵ�ǰ�ĳ�ջ��Ԫ�ص��Ҳ��һ��С�ڵ��ڵ�ֵ���ǵ�ǰԪ�ء�
                right[stack.pop()] = i;
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        long res = 0L;
        for (int i = 0; i < n; i++) {
            //���ݳ˷�ԭ�����Ԫ�صĸ��� * �Ҳ�Ԫ�صĸ��� = ���׵��ܴ�����
            res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % Mod;
        }
        return (int)res;
    }
}
