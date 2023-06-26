package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class l435 {
    /**
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
     * 逆向思维：
     * 按照每个区间的结束时间进行升序排序，找不重叠区间的个数 count
     * 如果第二个区间的开始时间>= 上一个区间的结束时间，count+1,更新结束时间
     * 此时需要移除的个数 = 总数 - 不重叠的个数
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
