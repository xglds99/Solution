package ͼ��;

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
            //ʹ���ڽӱ�ķ�ʽ��ͼ
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
                //�������� ������һ����ͨ����֮���򲻼��������ˡ�

                if(!visited[i]){
                    v = 0;
                    e = 0;
                    dfs(i);
                    //�������ȫ��ͨ������������ e == v(v - 1) /2
                    //��������ͳ�Ƶ�e ʵ������2e
                    if(e == v * (v - 1)) res ++;
                }
            }

            return res;
        }
        //ʹ��dfs�ķ�ʽͳ�� ��ͼ�ͱ���
        public void dfs(int x){
            visited[x] = true;
            v++;
            //������м������ӵĵ� �ͼӼ��������������� ����ͳ�������� ʵ�ʱ���������
            e += g[x].size();
            for(var y: g[x]){
                if(!visited[(int) y]) dfs((Integer) y);
            }
        }
    }
}
