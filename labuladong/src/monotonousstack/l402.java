package monotonousstack;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xgl
 * @date 2023/6/28 15:26
 */
public class l402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character>  deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while(!deque.isEmpty() && deque.peekLast() > c &&  k > 0) {
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
            if (leadZero && c == '0') continue;
            leadZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ?  "0" : sb.toString();
    }

    public static void main(String[] args) {
       Deque<Character> deque = new ArrayDeque<Character>();
       deque.offerLast('0');
        Character c = deque.pollLast();
        System.out.println(c == '0');
    }
}
