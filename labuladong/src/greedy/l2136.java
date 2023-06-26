package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class l2136 {

    /**
     *���� n ö�������ӡ�ÿö���ӱ��������£����ܿ�ʼ������������������Ҫʱ�䣬���ӵ�����Ҳ����ˡ����������±�� 0 ��ʼ���������� plantTime �� growTime ��ÿ������ĳ��ȶ��� n ��
     * <p>
     * plantTime[i] �� ���� �� i ö��������� �������� ��ÿ�죬��ֻ��Ϊ����ĳһö���Ӷ����������� �������춼����ͬһö���ӣ��������Ӳ��ֱ������㹤���������ﵽ plantTime[i] ֮�������ɡ�
     * growTime[i] �ǵ� i ö������ȫ���º���������� �������� ���������������һ�� ֮�� �����Ὺ��������Զ ���� ��
     * �ӵ� 0 ��ʼ������԰� ���� ˳�������ӡ�
     *
     * �����������Ӷ������� ���� һ���ǵڼ��졣
     *
     * ���� ����ʱ�䲻�ܲ��У� ����ʱ����Բ��У� �ò��е�ʱ����� ����Ҫ��ʱ�����
     * ̰��: ������ʱ����н�����������ʱ�䳤��������
     * ����ʱ�䲻���Բ��С������ܵĴ𰸾��� ���в���ʱ��� ���е�
     * @param plantTime
     * @param growTime
     * @return
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Integer[] id = IntStream.range(0, plantTime.length).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
        int res = 0, day = 0;
        for (int i : id){
            day += plantTime[i];
            res = Math.max(res, day + growTime[i]);
        }
        return res;
    }
}
