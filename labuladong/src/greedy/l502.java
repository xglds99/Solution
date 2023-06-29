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
    * @Date ���� ���ۣ�LeetCode��������ʼ IPO ��Ϊ���Ը��ߵļ۸񽫹�Ʊ��������Ͷ�ʹ�˾������ ϣ���� IPO ֮ǰ��չһЩ��Ŀ���������ʱ��� ������Դ���ޣ���ֻ���� IPO ֮ǰ������ k ����ͬ����Ŀ������ ���� ��������� k ����ͬ��Ŀ��õ�������ʱ��ķ�ʽ��
     *
     * ���� n ����Ŀ������ÿ����Ŀ i ��������һ�������� profits[i] ������������Ŀ��Ҫ����С�ʱ� capital[i] ��
     *
     * ���������ʱ�Ϊ w ���������һ����Ŀʱ���㽫��ô����������󽫱���ӵ�������ʱ��С�
     *
     * �ܶ���֮���Ӹ�����Ŀ��ѡ�� ��� k ����ͬ��Ŀ���б��� ��������ʱ� ����������տɻ�õ�����ʱ���
     *
     * �𰸱�֤�� 32 λ�з���������Χ�ڡ�
     * ���ʱ���������������ѡ������������Ŀ
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
