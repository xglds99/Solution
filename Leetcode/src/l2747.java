import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xgl
 * @date 2023/6/25 18:24
 */
public class l2747 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int nq = queries.length;
        Integer [] index = new Integer[nq];
        for (int i = 0; i < nq; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        int []res = new int[nq];
        int []cnt = new int[n + 1];
        int outOfRange = n, i = 0, j = 0;
        for(int id: index){
            while(i < logs.length && logs[i][1] <= queries[id])
                if (cnt[logs[i++][0]] ++ == 0){
                    outOfRange--;
                }
            while(j < logs.length && logs[j][1] < queries[id] - x){
                cnt[logs[j][0]]--;
                if (cnt[logs[j][0]] == 0){
                    outOfRange++;
                }
                j++;
            }
            res[id] = outOfRange;
        }
        return res;
    }
}
