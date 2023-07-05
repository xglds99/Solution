package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName l491
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 14:58
 * @Version 1.0
 */
public class l491 {
    private List<List<Integer>> res;
    private LinkedList<Integer> cur;
    private HashSet<List<Integer>> set;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        cur = new LinkedList<>();
        set = new HashSet<>();
        dfs(nums,0, -100000);
        return res;
    }

    public void dfs(int []nums, int start, int k){
        if (cur.size() >= 2) {
            ArrayList<Integer> newCur = new ArrayList<>(cur);
            if (!set.contains(newCur)) {
                res.add(new ArrayList<>(cur));
                set.add(newCur);
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] >= k){
                cur.addLast(nums[i]);
                dfs(nums,i + 1,nums[i]);
                cur.removeLast();
            }
        }
    }
}
