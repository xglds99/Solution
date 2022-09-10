package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * [1,2,2]
 */
public class subSet_2 {

    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return resu;
    }

    public void dfs(int start, int[] nums) {
        resu.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            //剪枝策略，如果递归树同一层，这个兄弟结点相同，那么就把这个相同的元素进行剪枝呈现在代码上就是 nums[i] == nums[i  -1] continue;
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            dfs(i + 1, nums);
            track.removeLast();
        }
    }
}
