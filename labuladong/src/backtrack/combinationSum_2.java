package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 */
public class combinationSum_2 {
    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return resu;
    }

    public void dfs(int[] candidates, int start, int target) {
        if (trackSum == target) {
            resu.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            //因为每个元素只能使用一次，所以下一层回溯树要从 i + 1 开始
            dfs(candidates, i + 1, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }

}
