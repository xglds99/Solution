import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l2044countMaxOrSubsets {

    @Test
    public void test(){
        int[] arr={1,8,5,4,6,7};
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<ArrayList<Integer>>printlist=new ArrayList<>();
        Arrays.sort(arr);
        group(arr,list,printlist,0);
        for(ArrayList<Integer>tem:printlist){
            System.out.println(Arrays.toString(tem.toArray()));
        }
    }
    public int countMaxOrSubsets(int nums[]){
        List<List<Integer>> maxList=new ArrayList<>();//存放最大值的子集
        return 0;
    }

    static ArrayList<ArrayList<Integer>>group(int[]arr,ArrayList<Integer>list,ArrayList<ArrayList<Integer>>printlist,int index){
        printlist.add(new ArrayList<>(list));
        if(list.size()==arr.length)
            return printlist;
        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            group(arr,list,printlist,i+1);
            list.remove(list.size()-1);
        }
        return printlist;
    }
}
