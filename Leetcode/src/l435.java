import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class l435 {
    /**
     * ����һ������ļ��� intervals ������ intervals[i] = [starti, endi] ������ ��Ҫ�Ƴ��������С������ʹʣ�����以���ص� ��
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);
        int count = 1;
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
