import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l56merge {
    /**
     * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
     * ����ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е��������䡣
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length - 1; i++) {
            int[] end = list.getLast();
            if(end[1] >= intervals[i][0]){
                list.removeLast();
                list.add(new int[]{end[0], Math.max(end[1], intervals[i][1])});
            }else{
                list.add(intervals[i]);
            }
        }
        int [][]res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
