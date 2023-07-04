package doublepointer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName l826
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/4 9:46
 * @Version 1.0
 */
public class l826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        Integer []id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, Comparator.comparingInt(a -> difficulty[a]));
        Arrays.sort(worker);
        int i = 0;
        int j = 0;
        int res = 0;
        int best = 0;
        for (int x : worker){
            while(i < n && x >= difficulty[id[i]]){
                best = Math.max(best,profit[id[i++]]);
            }
            res += best;
        }
        return res;
    }
}
