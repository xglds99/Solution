package greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xgl
 * @date 2023/6/28 16:37
 */
public class l402 {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<Character>();
            int n = num.length();
            for (int i = 0; i < n; i++) {
                char c = num.charAt(i);
                while(!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(c);
            }
            for (int i = 0; i < k; i++) {
                deque.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            boolean leadZero = true;
            while (!deque.isEmpty()) {
                Character c = deque.pollFirst();
                if (leadZero && c == '0')continue;
                leadZero = false;
                sb.append(c);
            }
            if (sb.length() == 0) return "0";
            return sb.toString();
        }

}
