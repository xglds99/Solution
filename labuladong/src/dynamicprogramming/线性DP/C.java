package dynamicprogramming.ÏßÐÔDP;

import com.sun.jdi.connect.spi.TransportService;

import java.util.Arrays;
import java.util.LinkedList;

public class C {



//    private LinkedList<Integer> list = new LinkedList<>();
//    private boolean []used;
//    private  int MOD = (int) 1e9 + 7;
//    private int res = 0;
//    public int specialPerm(int[] nums) {
//        used = new boolean[nums.length];
//        dfs(nums,used,0);
//        return  res;
//    }
//
//
//    public void dfs(int []nums, boolean []used, int depth){
//        if (depth == nums.length){
//            boolean f1 = true;
//            for (int i = 0; i < nums.length - 1; i++){
//                if (list.get(i) % list.get(i + 1) != 0 && list.get(i + 1) % list.get(i) != 0) {
//                    f1 = false;
//                    break;
//                }
//            }
//            if (f1) res = (res + 1)  % MOD;
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]){
//                if (depth > 0 && list.get(depth) % nums[i] != 0 && nums[i] % list.get(depth) != 0)continue;
//                list.addLast(nums[i]);
//                used[i] = true;
//                dfs(nums, used,depth + 1);
//                list.removeLast();
//                used[i] = false;
//            }
//        }
//    }

//    private int MOD = (int)1e9 + 7;
//    public int specialPerm(int []nums){
//        int n = nums.length;
//        int m = 1 << n;
//        int [][]dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//
//            }
//        }
//    }
}
