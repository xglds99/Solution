package dynamicprogramming.线性DP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/30 19:57
 */
public class l2121 {
    /**
     * @return
     * @Author xgl
     * @Description 给你一个下标从 0 开始、由 n 个整数组成的数组 arr
     * arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。
     * 返回一个长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和
     * 注意：|x| 是 x 的绝对值。
     * @Date 19:57 2023/5/30
     * @Param
     **/

    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        int n = arr.length;
        long[] res = new long[n];
        Collection<List<Integer>> values = map.values();
        for (List<Integer> v : values) {
            long p0;
            long sum = 0l;
            int t = v.size();
            for (int i : v) {
                sum += v.get(i);
            }
            p0 = sum - (long) t * v.get(0);
            res[v.get(0)] = p0;
            for (int i = 1; i < v.size(); i++) {
                res[v.get(i)] = p0 + (t - 2 * i ) * (v.get(i - 1) - v.get(i));
                p0  = res[v.get(i)];
            }
        }
        return res;

    }
}
