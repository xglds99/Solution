package backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class permute {
    List<List<Integer>> resu = new ArrayList<>();
    public List<List<Integer>> permute_back(int []nums){
        int len = nums.length;
        boolean []used =new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,len,0,used,path);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> q: resu){
            String b = "";
            for(int a: q) b+=a;
            res.add(Integer.parseInt(b));
            System.out.println(b);
        }
        return resu;
    }

    public void dfs(int []nums,int len,int depth,boolean []used,Deque<Integer> path){
        if(depth == len){
            resu.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i< len ;i++){
            //怎么样保证选取的元素不会重复，通过使用一个used数组，如果一个元素对应的下表是true，就被使用，不应该被加入列表
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, used, path); //回溯
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
    int []nums = {1,2,3};
        System.out.println(new permute().permute_back(nums));
    }
}
