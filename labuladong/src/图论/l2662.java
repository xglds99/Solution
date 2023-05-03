package 图论;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xgl
 * @date 2023/5/3 20:23
 */
public class l2662 {

        public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
            long t = (long) target[0] << 32 | target[1];
            var dis = new HashMap<Long, Integer>();
            dis.put(t, Integer.MAX_VALUE);
            dis.put((long) start[0] << 32 | start[1], 0);
            var vis = new HashSet<Long>();
            for (;;) {
                long v = -1;
                int dv = -1;
                for (var e : dis.entrySet())
                    if (!vis.contains(e.getKey()) && (dv < 0 || e.getValue() < dv)) {
                        v = e.getKey();
                        dv = e.getValue();
                    }
                if (v == t) return dv; // 到终点的最短路已确定
                vis.add(v);
                int vx = (int) (v >> 32), vy = (int) (v & Integer.MAX_VALUE);
                // 更新到终点的最短路
                dis.merge(t, dv + target[0] - vx + target[1] - vy, Math::min);
                for (var r : specialRoads) {
                    int d = dv + Math.abs(r[0] - vx) + Math.abs(r[1] - vy) + r[4];
                    long w = (long) r[2] << 32 | r[3];
                    if (d < dis.getOrDefault(w, Integer.MAX_VALUE))
                        dis.put(w, d);
                }
            }
        }

}





