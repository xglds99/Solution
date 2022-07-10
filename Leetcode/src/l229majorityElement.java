import java.util.ArrayList;
import java.util.List;

public class l229majorityElement {
    /*
1 在任何数组中，出现次数大于该数组长度一半的值只能有一个.
2 在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。
这样不断的删除直到无法再进行投票，如果数组为空，
则没有任何元素出现的次数超过该数组长度的一半。
如果只存在一种元素，那么这个元素则可能为目标元素。

     */
    public static void main(String[] args) {

    }
    public  static List<Integer> majorityElement(int nums[]){
        //暴力解法
        ArrayList<Integer> list = new ArrayList<Integer>();
        int val1=-1,val2=-1;
        int count1=0,count2=0;
        int max=nums.length/3;

        for(int num :nums){
            if(num ==val1) {
                count1++;
                continue;
            }
            if(num ==val2){
                count2++;
                continue;
            }
            if(count1==0){
                val1=num;
                count1++;
                continue;
            }
            if(count2==0){
                val2=num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

         count1=0;count2=0;
        for(int num :nums){
            if(num ==val1){
                count1++;
            }
            else  if(num ==val2){
                count2++;
            }
        }

        if(count1 >max)
            list.add(val1);
        if(count2>max)
            list.add(val2);
        if(val1==val2);
        list.remove(1);
        return  list;
    }
}
