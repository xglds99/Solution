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
            //剪纸策略，保证两个相同元素的相对位置不变，来保证没有重复的集合。
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
