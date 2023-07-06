import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName l2178
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/6 12:55
 * @Version 1.0
 */
public class l2178 {
    LinkedList<Long> list = new LinkedList<>();
    List<Long> res = new ArrayList<>();

    private  long memo[][];
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return res;
        Long cur = 0L;
        dfs(cur,0,finalSum);
        return res;
    }


    public void dfs(Long cur, long start,Long finalSum){
        if (Objects.equals(cur, finalSum) && list.size() > res.size()){
            res = new ArrayList<>(list);
            return;
        }
        for (long i = start; i <= finalSum; i+=2) {
            if (cur + i > finalSum)return;
            cur += i;
            list.addLast(i);
            dfs(cur,i + 2,finalSum);
            cur-=i;
            list.removeLast();
        }
    }
}
