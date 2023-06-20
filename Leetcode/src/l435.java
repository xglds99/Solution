import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class l435 {
    /**
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
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
