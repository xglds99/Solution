package backtrack;

import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return resu;
    }

    public void dfs(int[] candidates, int target, int start) {
        if (trackSum == target) {
            resu.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            // 同一元素可重复使用，注意参数
            //所以对于递归的参数，让每一层回溯数，都从当前的i开始，就可以使用相同的元素
            //但是不让任由回溯树一直递归下去，设置限定条件来结束回溯树的递归
            dfs(candidates, target, i);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }


}
