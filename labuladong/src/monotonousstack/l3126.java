package monotonousstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xgl
 * @date 2023/6/28 14:27
 */
public class l3126 {
    public String removeDuplicateLetters(String s){
        Deque<Character> deque = new ArrayDeque<>();
        int []map = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
        }
        boolean []inStack = new boolean[256];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map[c]--;
            if (inStack[c]) continue;
            while(!deque.isEmpty() && deque.peek() > c){
                if (map[deque.peek()] == 0) break;
                inStack[deque.poll()] = false;
            }
            deque.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.poll());
        }
        return sb.reverse().toString();
    }
}
