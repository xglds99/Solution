package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * nums存在重复元素
 */
public class permute_2 {

    List<List<Integer>> resu = new ArrayList<>();
    LinkedList<Integer> track =new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean []used = new boolean[nums.length];
        dfs(nums,0,used);
        return resu;
    }

    public void dfs(int []nums,int start,boolean []used){
        if(start == nums.length){
            resu.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length ; i++){
            //标准全排列算法之所以出现重复，是因为把相同元素形成的排列序列视为不同的序列，但实际上它们应该是相同的；而如果固定相同元素形成的序列顺序，当然就避免了重复。
            //剪枝策略，保证两个相同元素的相对位置不变，来保证没有重复的集合。 // 如果前面的相邻相等元素没有用过，则跳过
           //当出现重复元素时，比如输入 nums = [1,2,2',2'']，2' 只有在 2 已经被使用的情况下才会被选择，
            // 同理，2'' 只有在 2' 已经被使用的情况下才会被选择，这就保证了相同元素在排列中的相对位置保证固定
            if( i > 0 && nums[i] == nums[i -1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                track.addLast(nums[i]);
                used[i] = true;
                dfs(nums,start + 1,used);
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
