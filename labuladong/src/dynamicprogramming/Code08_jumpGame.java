package dynamicprogramming;

public class Code08_jumpGame {

    public boolean jump(int []nums){

        int farMost = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i ++){
            //每次都计算从当前位置能跳到的最远距离。
            farMost = Math.max(farMost,i + nums[i]);
            if (farMost <= i){
                return false;
            }
        }
        return farMost >= n - 1;

    }
}
