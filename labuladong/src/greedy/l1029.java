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
     * ��˾�ƻ����� 2n �ˡ�����һ������ costs ������ costs[i] = [aCosti, bCosti] ���� i �˷��� a �еķ���Ϊ aCosti ������ b �еķ���Ϊ bCosti ��
     *
     * ���ؽ�ÿ���˶��ɵ� a ��b ��ĳ�����е���ͷ��ã�Ҫ��ÿ�����ж��� n �˵ִ
    * @Date 11:16 2023/6/7
    * @Param
    * @return
    **/
    /**
    * @Author xgl
    * @Description
     * ����˼·��̰��+����
     * �����������˶�ȥB���У���a���еĳɱ���Ϊa[i] -b[i];
     *������a���еĳɱ�������������
     * ����ѡ��ǰn�� ��Ϊȥa���еĳɱ�
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
