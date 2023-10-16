import java.util.ArrayDeque;

/**
 * @author xgl
 * @date 2023/6/26 20:43
 */
public class l2434 {
    /**
     * @return java.lang.String
     * @Author xgl
     * @Description ����һ���ַ��� s ��һ�������ˣ������˵�ǰ��һ�����ַ��� t ��ִ�����²���֮һ��ֱ�� s �� t ����ɿ��ַ�����
     * <p>
     * ɾ���ַ��� s �� ��һ�� �ַ����������ַ��������ˡ������˰�����ַ���ӵ� t ��β����
     * ɾ���ַ��� t �� ���һ�� �ַ����������ַ��������ˡ������˽����ַ�д��ֽ�ϡ�
     * ���㷵��ֽ����д�����ֵ�����С���ַ�����
     * @Date 20:45 2023/6/26
     * @Param [s]
     **/
//    public String robotWithString(String s) {
//        int[] min = new int[s.length()];
//        for (int i = s.length() - 1; i > 0; i--) {
//            min[i - 1] = Math.min(s.charAt(i), i < s.length() - 1 ? min[i] : 'z');
//        }
//        StringBuilder sb = new StringBuilder();
//        ArrayDeque<Character> deque = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++) {
//            for (deque.push(s.charAt(i)); !deque.isEmpty() && deque.peek() <= min[i]; ) {
//                sb.append(deque.pop());
//            }
//        }
//        while (!deque.isEmpty()) {
//            sb.append(deque.pop());
//        }
//        return sb.toString();
//    }

    class Solution {
        /**
         * @return java.lang.String
         * @Author xgl
         * @Description ˼·:
         * ����ʹ��һ�������¼ÿ����ĸ���ֵĴ���
         * �����ַ���s�� ��һ��min��¼��ǰʣ���ַ�������С���ַ�����������
         * ��ǰ�ַ�c �����֮���б�c�ֵ����С���ַ���cѹջ����������
         * Ȼ����µ�ǰ����С�ַ�
         * ���ջ�����ַ��ȵ�ǰ����С�ַ�С����ջ���ַ���ջ�����
         * @Date 20:59 2023/6/26
         * @Param [S]
         **/
        public String robotWithString(String S) {
            var res = new StringBuilder();
            var s = S.toCharArray();
            var map = new int[26];
            for (var c : s) {
                map[c - 'a']++;
            }

            int min = 0;
            var stack = new ArrayDeque<Character>();
            for (var c : s) {
                map[c - 'a']--;
                while (min < 25 && map[min] == 0) min++;
                if (c - 'a' == min) {
                    res.append(c);
                } else {
                    stack.push(c);
                }
                while (!stack.isEmpty() && stack.peek() - 'a' <= min) {
                    res.append(stack.pop());
                }
            }
            return res.toString();
        }
    }
}
