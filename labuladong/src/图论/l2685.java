package 图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/17 19:08
 */
public class l2685 {
    class Solution {
        private ArrayList[] g;
        private boolean []visited;
        private int v, e;
        public int countCompleteComponents(int n, int[][] edges) {
            g = new ArrayList[n];
            //使用邻接表的方式建图
            Arrays.setAll(g , e -> new ArrayList());
            for(var e: edges){
                int x = e[0];
                int y = e[1];
                g[x].add(y);
                g[y].add(x);
            }

            int res = 0;
            visited = new boolean[n];
            for(int i = 0; i < n ;i ++){
                //如果这个点 被加入一条联通分量之后，则不继续遍历了。

                if(!visited[i]){
                    v = 0;
                    e = 0;
                    dfs(i);
                    //如果是完全联通分量，则满足 e == v(v - 1) /2
                    //但是这里统计的e 实际上是2e
                    if(e == v * (v - 1)) res ++;
                }
            }

            return res;
        }
        //使用dfs的方式统计 点图和边数
        public void dfs(int x){
            visited[x] = true;
            v++;
            //这个点有几个连接的点 就加几，但是这样导致 边数统计了两遍 实际边数的两倍
            e += g[x].size();
            for(var y: g[x]){
                if(!visited[(int) y]) dfs((Integer) y);
            }
        }
    }
}
