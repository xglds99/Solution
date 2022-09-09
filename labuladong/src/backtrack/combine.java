package backtrack;

import java.util.LinkedList;
import java.util.List;

public class combine {
//×éºÏ
    List<List<Integer>> resu = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine_1(int n, int k) {
        int []nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        dfs(0,nums,k);
        return resu;
    }

    public void dfs(int start,int []nums,int k){
        if(track.size() == k){
            resu.add(new LinkedList<>(track));
        }
        for(int i = start ;i < nums.length ; i++){
            track.addLast(nums[i]);
            dfs( i + 1,nums,k);
            track.removeLast();
        }
    }
}
