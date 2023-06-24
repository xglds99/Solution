package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xgl
 * @date 2023/6/7 11:16
 */
public class l1029 {
    /***
    * @Author xgl
    * @Description
     * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
     *
     * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
    * @Date 11:16 2023/6/7
    * @Param
    * @return
    **/
    /**
    * @Author xgl
    * @Description
     * 解题思路：贪心+排序
     * 首先让所有人都去B城市，将a城市的成本改为a[i] -b[i];
     *这样对a城市的成本进行升序排序。
     * 从中选择前n个 作为去a城市的成本
    * @Date 11:17 2023/6/7
    * @Param [costs]
    * @return int
    **/
    public int twoCitySchedCost(int[][] costs) {
        int m = costs.length;
        int res = 0;
        for(int i = 0; i < m; i++){
            res += costs[i][1];
            costs[i][0] -= costs[i][1];
        }
        Arrays.sort(costs, Comparator.comparingInt(a -> a[0]));
        for(int j = 0; j < m / 2; j++){
            res += costs[j][0];
        }
        return res;

    }
}
