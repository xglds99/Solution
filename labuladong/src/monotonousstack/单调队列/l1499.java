package monotonousstack.单调队列;

import java.util.LinkedList;

/**
 * @ClassName l1499
 * @Description
 * @Author xgl
 * @Date 2023/7/21 11:57
 * @Version 1.0
 */
public class l1499 {
    public int findMaxValueOfEquation(int [][]points, int k){
        int n = points.length;
        LinkedList<int []> queue = new LinkedList<>();
        int res = 0;
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!queue.isEmpty() && queue.peekFirst()[0] <= x - k) queue.pollFirst();
            if (!queue.isEmpty())
                res = Math.max(res, x + y + queue.peekFirst()[1]);
            while (!queue.isEmpty() && queue.peekLast()[1] < y - x) queue.pollLast();
            queue.addLast(new int[]{x, y - x});
        }
        return res;
    }
}
