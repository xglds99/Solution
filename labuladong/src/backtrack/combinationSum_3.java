package backtrack;

import java.util.LinkedList;
import java.util.List;

public class combinationSum_3 {

    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
        dfs(0, nums, k, n);
        return resu;
    }

    public void dfs(int start, int[] nums, int k, int n) {
        if (trackSum == n && track.size() == k) {
            resu.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            trackSum += nums[i];
            dfs(i + 1, nums, k, n);
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
