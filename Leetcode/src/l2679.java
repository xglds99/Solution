import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @ClassName l2679
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/4 9:13
 * @Version 1.0
 */
public class l2679 {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        PriorityQueue<Integer>[] pq = new PriorityQueue[m];
        for (int i = 0; i < m; i++) {
            pq[i] = new PriorityQueue<>((a,b)->b -a);
            for (int j = 0; j < n; j++) {
                pq[i].offer(nums[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                cur = Math.max(cur, pq[j].poll());
            }
        res += cur;
        }
    return res;
    }
}
