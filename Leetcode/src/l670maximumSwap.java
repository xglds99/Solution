import java.util.ArrayDeque;
import java.util.Deque;

public class l670maximumSwap {

    //����һ���Ǹ���������������Խ���һ�������е�������λ���������ܵõ������ֵ��
        public int maximumSwap(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            int n = chars.length;
            int left = n, right = n;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && chars[stack.peekLast()] < chars[i]) {
                    int idx = stack.removeLast();
                    if (idx < left) {
                        left = idx;
                        right = i;
                    }
                    if (idx == right) {
                        right = i;
                    }
                }
                if (right < n && chars[right] == chars[i]) {
                    right = i;
                }
                stack.addLast(i);
            }
            if (left < n) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                return Integer.parseInt(new String(chars));
            }
            return num;
        }

}
