package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class l435 {
    /**
     * ����һ������ļ��� intervals ������ intervals[i] = [starti, endi] ������ ��Ҫ�Ƴ��������С������ʹʣ�����以���ص� ��
     * ����˼ά��
     * ����ÿ������Ľ���ʱ��������������Ҳ��ص�����ĸ��� count
     * ����ڶ�������Ŀ�ʼʱ��>= ��һ������Ľ���ʱ�䣬count+1,���½���ʱ��
     * ��ʱ��Ҫ�Ƴ��ĸ��� = ���� - ���ص��ĸ���
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        var count = 1;
        int end = intervals[0][1];
        for(var interval: intervals){
            if(interval[0] >= end){
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
