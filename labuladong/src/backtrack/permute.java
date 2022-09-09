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
        return resu;
    }

    public void dfs(int []nums,int len,int depth,boolean []used,Deque<Integer> path){
        if(depth == len){
            resu.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i< len ;i++){
            System.out.println("当前所在层数:" + depth);
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;
                System.out.println("递归之前==>" + path);
                dfs(nums, len, depth + 1, used, path); //回溯
                path.removeLast();
                used[i] = false;
                System.out.println("递归之后==>" + path);
            }
        }
    }

    public static void main(String[] args) {
    int []nums = {1,2,3};
        System.out.println(new permute().permute_back(nums));
    }
}
