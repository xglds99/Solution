import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
}
