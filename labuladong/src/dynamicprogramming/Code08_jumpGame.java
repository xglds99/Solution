package dynamicprogramming;

public class Code08_jumpGame {

    public boolean jump(int []nums){

        int farMost = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i ++){
            //ÿ�ζ�����ӵ�ǰλ������������Զ���롣
            farMost = Math.max(farMost,i + nums[i]);
            if (farMost <= i){
                return false;
            }
        }
        return farMost >= n - 1;

    }
}
