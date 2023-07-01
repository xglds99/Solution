import java.util.*;

/**
 * @author xgl
 * @date 2023/6/29 10:23
 */
public class l2751 {

        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            int n = positions.length;
            Integer []index= new Integer[n];
            for (int i = 0; i < n ; i++) {
                index[i] = i;
            }
            Arrays.sort(index, Comparator.comparingInt(a -> positions[a]));
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (directions.charAt(index[i])  == 'L'){
                    while (deque.size() > 0 && healths[index[i]] > 0){
                        if (healths[deque.peek()] > healths[index[i]]){
                            healths[index[i]] = 0;
                            healths[deque.peek()]--;
                        }else if (healths[deque.peek()] < healths[index[i]]){
                            healths[index[i]]--;
                            healths[deque.pop()] = 0;
                        }else {
                            healths[index[i]] = healths[deque.pop()] = 0;
                        }
                    }
                }else{
                    deque.push(index[i]);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int health : healths) {
                if (health > 0) {
                    list.add(health);
                }
            }
            return list;
        }

}
