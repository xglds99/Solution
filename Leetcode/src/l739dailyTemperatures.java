import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class l739dailyTemperatures {
    @Test
    public void test() {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] resu = dailyTemperatures(temperatures);
        int[] answer = dailyTempretures1(temperatures);
        for (int i = 0; i < resu.length; i++) {
            System.out.print(resu[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    /**
     * 构建一个递减的单调栈
     *
     * @param tempreatures
     * @return
     */
    public int[] dailyTempretures1(int[] tempreatures) {
        Deque<Integer> deque = new LinkedList<>();
        int answer[] = new int[tempreatures.length];
        for (int i = 0; i < tempreatures.length; i++) {
            if (deque.isEmpty() || tempreatures[deque.peek()] > tempreatures[i]) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && tempreatures[deque.peek()] < tempreatures[i]) {


                    answer[deque.peek()] = i - deque.pop();
                }
                deque.push(i);
            }
        }
        return answer;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < temperatures.length; i++) {
            index = 0;
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = index;
                    flag = true;
                    break;
                }
                index++;
            }
            if (!flag) {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
