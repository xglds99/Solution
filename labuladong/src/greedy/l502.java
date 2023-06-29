package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xgl
 * @date 2023/6/29 11:08
 */
public class l502 {
    /**
    * @Author xgl
    * @Description
    * @Date 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
     *
     * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
     *
     * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     *
     * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
     *
     * 答案保证在 32 位有符号整数范围内。
     * 在资本允许的情况下优先选择利润最大的项目
     * 2023/6/29=
    * @Author xgl
    * @Description
    * @Date 11:17 2023/6/29
    * @Param [k, w, profits, capital]
    * @return int
    **/
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer []index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> capital[a]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            while(cur < n && capital[index[cur]] <= w){
                pq.add(profits[index[cur]]);
                cur++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            }else
            {
                break;
            }
        }
        return w;
    }
}
