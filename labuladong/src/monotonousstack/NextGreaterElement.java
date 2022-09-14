package monotonousstack;

import java.util.Stack;

public class NextGreaterElement {

    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // ��Ŵ𰸵�����
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // ������ջ���
        for (int i = n - 1; i >= 0; i--) {
            // �ж����Ӹ߰�
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // �����𿪣�����Ҳ�������ˡ�����
                s.pop();
            }
            // nums[i] ���ĸ���Ԫ��
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
