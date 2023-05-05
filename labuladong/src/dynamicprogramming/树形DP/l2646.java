package dynamicprogramming.����DP;

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
                g[y].add(x); // ����
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
            if (x == end) { // �����յ㣨ע����ֻ��Ψһ��һ����·����
                ++cnt[x]; // ͳ�ƴ� start �� end ��·���ϵĵ㾭���˶��ٴ�
                return true; // �ҵ��յ�
            }
            for (var y : g[x])
                if (y != fa && path(y, x)) {
                    ++cnt[x]; // ͳ�ƴ� start �� end ��·���ϵĵ㾭���˶��ٴ�
                    return true; // �ҵ��յ�
                }
            return false; // δ�ҵ��յ�
        }

        // ���� 337. ��ҽ��� III https://leetcode.cn/problems/house-robber-iii/
        private int[] dfs(int x, int fa) {
            int notHalve = price[x] * cnt[x]; // x ����
            int halve = notHalve / 2; // x ����
            for (var y : g[x])
                if (y != fa) {
                    var p = dfs(y, x); // ���� y ����/�������С��ֵ�ܺ�
                    notHalve += Math.min(p[0], p[1]); // x ���䣬��ô y ���Բ��䣬���Լ��룬ȡ�������������Сֵ
                    halve += p[0]; // x ���룬��ô y ֻ�ܲ���
                }
            return new int[]{notHalve, halve};
        }

}
