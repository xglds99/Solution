package dynamicprogramming.����DP;

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
     * @Description ����һ���±�� 0 ��ʼ���� n ��������ɵ����� arr
     * arr ������Ԫ�ص� ��� ����Ϊ�����±�֮��� ���Բ� ������ʽ�أ�arr[i] �� arr[j] ֮��ļ���� |i - j| ��
     * ����һ������Ϊ n ������ intervals ������ intervals[i] �� arr[i] �� arr ��ÿ����ͬԪ�أ��� arr[i] ��ֵ��ͬ���� ���֮��
     * ע�⣺|x| �� x �ľ���ֵ��
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
