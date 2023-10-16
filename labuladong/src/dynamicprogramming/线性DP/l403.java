package dynamicprogramming.����DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class l403 {

    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final HashMap<String, Boolean> memo = new HashMap<>();

    /**
     * ������Ϸ
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        if (!map.containsKey(1)) return false;
        return dfs(stones, 1, 1, n);
    }

    /**
     * @param stones
     * @param start
     * @param k
     * @param n
     * @return
     */
    //��start��������һ������k�����Ƿ���Ե������һ������
    public boolean dfs(int[] stones, int start, int k, int n) {
        String key = start + "_" + k;
        if (memo.containsKey(key)) return memo.get(key);
        if (start == n - 1) return true;
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) continue; //��ֻ֤����ǰ��
            int next = stones[start] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, map.get(next), k + i, n);
                memo.put(key, cur);
                if (cur) return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    static class Solution {
        /**
         * �����ġ�״̬���塹������ĺ��壺��ǰ�ڵ� iii ��λ�ã��������Բ��� kkk ����λ�� iii ʱ���Ƿ񵽴����һ��ʯ�ӡ�
         * ��ô���� f[i][k] �Ƿ�Ϊ�棬��ȡ������һλ�� jjj ��״ֵ̬�����ÿ�β����ı仯Ϊ [-1,0,1] ��֪��
         * �ɴ� f[j][k?1] ״̬���������Ǿ��� k?1 ����Ծ����λ�� jjj������ԭ�����Ļ����� +1��������λ�� iii��
         * �ɴ� f[j][k] ״̬���������Ǿ��� kkk ����Ծ����λ�� jjj��ά��ԭ�������䣬������λ�� iii��
         * �ɴ� f[j][k+1] ״̬���������Ǿ��� k+1k + 1k+1 ����Ծ����λ�� jjj������ԭ�����Ļ����� -1��������λ�� iii��
         * ֻҪ���������������һ��Ϊ�棬�� f[i][j] Ϊ�档
         * ���ˣ����ǽ���˶�̬�滮�ġ�״̬���塹&��״̬ת�Ʒ��̡����֡�
         * ����ͽ������𣿻�û�С�
         * ���ǻ�ȱ�ٿ���״̬������ȥ�ġ���Чֵ��������˵ȱ�ٳ�ʼ�����ڡ�
         * ��Ϊ���ǵ� f[i][k]f[i][k]f[i][k] ������֮ǰ��״̬���С������㡱������ת�Ʒ��̱�������� true ֵ�����Ϊ�������������ơ����̿ɹ�����������Ҫ����һ��Ϊ true��״ֵ̬��
         * ��ʱ���ٻؿ����ǵ�״̬���壺��ǰ�ڵ� iii ��λ�ã��������Բ��� kkk ����λ�� iii ʱ���Ƿ񵽴����һ��ʯ�ӡ�
         * ��Ȼ�����������ǲ�����֪�����������Ĳ�������������Щλ�á������տ��Ե������һ��ʯ�ӡ�
         * ��ʱ����Ҫ���á���ż�ԡ�����Ծ���̡���ת������������
         * ����֪����ʼ״̬�ǡ���������Ϊ 1������Ծ���λ�� 1�����������ʼ״̬����������һ�ַ����������һ��ʯ�ӵĻ�����ô��Ȼ����һ������·���������Դӡ����һ��ʯ�ӡ���ʼ�����ԡ�ĳ������ kkk����ʼ��Ծ�������Իص�λ�� 1��
         * ������ǿ����� f[1][1]= true����Ϊ���ǵ���ʼֵ��
         * ���ﱾ�������á�·�����桹�����ʣ�����������ˡ���Ч��ż���������������ǽ��С�������ơ�������ʵ������������֤�Ƿ����ĳ��������·��������λ�� 111��
         *
         * @param ss
         * @return
         */
        public boolean canCross(int[] ss) {
            int n = ss.length;
            // check first step
            if (ss[1] != 1) return false;
            //1.���� dp[i][j]����ǰ��λ��i����һ����Ծ����Ϊj���Ƿ���Ե����յ㡣
            boolean[][] f = new boolean[n + 1][n + 1];
            f[1][1] = true;
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    int k = ss[i] - ss[j];
                    // ����֪����λ�� j ��λ�� i ����Ҫ����Ϊ k ����Ծ
                    // ����λ�� j �������Ծ��಻���� j + 1
                    // ��Ϊÿ����Ծ���±��������� 1��������������� 1
                    //Ϊʲô k<= j + 1��
                    //��Ϊ��j��ǰһ��λ����k����λ��j�����Դ�j������ܵ�j+1��λ��
                    if (k <= j + 1) {
                        f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (f[n - 1][i]) return true;
            }
            return false;
        }
    }

}
