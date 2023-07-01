package mathquestion;

import org.junit.Test;

import java.util.*;

/**
 * @author xgl
 * @date 2023/6/26 16:45
 */
public class l365 {
    /**
    * @Author xgl
    * @Description 判断z是否是x,y最大公因数的整数倍
    * @Date 16:46 2023/6/26
    * @Param [x, y, z]
    * @return boolean
    **/
    public boolean canMeasureWater(int x, int y, int z){
        if (z == 0) return true;
        if (x + y < z)return false;
        if(x == 0)return y == z;
        if (y == 0)return x == z;
        int a = gcd(x, y);
        return z % a == 0;

    }


    public int gcd(int a, int b){
        if (b == 0)return a;
        return gcd(b, a % b);
    }


    @Test
    public void test(){
        System.out.println(gcd(5,3));
    }

    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (z == 0) {
                return true;
            }
            if (x + y < z) {
                return false;
            }
            Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
            AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
            queue.add(start);
            Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
            visited.add(start);
            while (!queue.isEmpty()) {
                Map.Entry<Integer, Integer> entry = queue.poll();
                int curX = entry.getKey();
                int curY = entry.getValue();
                if (curX == z || curY == z || curX + curY == z) {
                    return true;
                }
                if (curX == 0) {
                    // 把第一个桶填满
                    addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
                }
                if (curY == 0) {
                    // 把第二个桶填满
                    addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, y));
                }
                if (curY < y) {
                    // 把第一个桶倒空
                    addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, curY));
                }
                if (curX < x) {
                    // 把第二个桶倒空
                    addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, 0));
                }

                // y - curY是第二个桶还可以再加的水的升数，但是最多只能加curX升水。
                int moveSize = Math.min(curX, y - curY);
                // 把第一个桶里的curX升水倒到第二个桶里去。
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
                // 反过来同理，x - curX是第一个桶还可以再加的升数，但是最多只能加curY升水。
                moveSize = Math.min(curY, x - curX);
                // 把第一个桶里的curX升水倒到第二个桶里去。
                addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX + moveSize, curY - moveSize));
            }
            return false;
        }

        private void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
                                  Set<Map.Entry<Integer, Integer>> visited,
                                  Map.Entry<Integer, Integer> newEntry) {
            if (!visited.contains(newEntry)) {
                visited.add(newEntry);
                queue.add(newEntry);
            }
        }
    }


}
