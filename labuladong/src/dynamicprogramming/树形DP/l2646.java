package dynamicprogramming.树形DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/4 15:10
 */
public class l2646 {


        private List<Integer>[] g;
        private int[] price, cnt;
        private int end;

        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (var e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x); // 建树
            }
            this.price = price;

            cnt = new int[n];
            for (var t : trips) {
                end = t[1];
                path(t[0], -1);
            }

            var p = dfs(0, -1);
            return Math.min(p[0], p[1]);
        }

        private boolean path(int x, int fa) {
            if (x == end) { // 到达终点（注意树只有唯一的一条简单路径）
                ++cnt[x]; // 统计从 start 到 end 的路径上的点经过了多少次
                return true; // 找到终点
            }
            for (var y : g[x])
                if (y != fa && path(y, x)) {
                    ++cnt[x]; // 统计从 start 到 end 的路径上的点经过了多少次
                    return true; // 找到终点
                }
            return false; // 未找到终点
        }

        // 类似 337. 打家劫舍 III https://leetcode.cn/problems/house-robber-iii/
        private int[] dfs(int x, int fa) {
            int notHalve = price[x] * cnt[x]; // x 不变
            int halve = notHalve / 2; // x 减半
            for (var y : g[x])
                if (y != fa) {
                    var p = dfs(y, x); // 计算 y 不变/减半的最小价值总和
                    notHalve += Math.min(p[0], p[1]); // x 不变，那么 y 可以不变，可以减半，取这两种情况的最小值
                    halve += p[0]; // x 减半，那么 y 只能不变
                }
            return new int[]{notHalve, halve};
        }

}
