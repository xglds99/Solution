import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xgl
 * @date 2023/6/29 10:11
 */
public class l735 {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int a = asteroids[i];
            if (a < 0) {
                while (!deque.isEmpty() && asteroids[deque.peek()] < Math.abs(a)) {
                    asteroids[deque.poll()] = 0;
                }
                if (!deque.isEmpty() && asteroids[deque.peek()] == Math.abs(a)) {
                    asteroids[i] = 0;
                    asteroids[deque.poll()] = 0;
                } else if
                (!deque.isEmpty() && asteroids[deque.peek()] > Math.abs(a)){
                    asteroids[i] = 0;
                }
            } else {
                deque.push(i);
            }
        }
        int cnt = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) cnt++;
        }
        int []res = new int[cnt];
        int j = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                res[j++] = asteroid;
            }
        }
    return res;
    }

}
