import org.junit.Test;

import java.util.*;

public class l46permute {


    public static void main(String[] args) {
        l46permute l46permute=new l46permute();
       int a[]=new int[]{1,2,3};
//       int []x=new int[100];
//       int n=a.length;
//        System.out.println("结果为：");
//        l46permute.dfs(a,n,0,x);
        for (List list:   l46permute.permute(a)){
            System.out.println(list);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    //回溯+深度优先遍历
    public void dispasolution(int a[],int n,int []x){
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if(x[i]==1){
                System.out.print(a[i]);
            }
        }
        System.out.print("}");
    }

    public void dfs(int []a,int n,int i,int x[]){
        if(i>=n){
            dispasolution(a,n,x);
        }  else{
            x[i]=0;dfs(a,n,i+1,x);
            x[i]=1;dfs(a,n,i+1,x);
        }
    }



     static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         Deque<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;

                    System.out.println("  递归之前 => " + path);
                    dfs(nums, len, depth + 1, path, used, res);

                    used[i] = false;
                    path.removeLast();
                    System.out.println("递归之后 => " + path);
                }
            }
        }


    }
    @Test
    public  void test() {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
