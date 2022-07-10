public class l66plusone {
    public int[] plusOne(int []nums){
        int n= nums.length;
        for (int i = n-1; i < nums.length; i++) {
            if(nums[i]!=9){
                nums[i]++;
                for (int j = i+1; j <  n ; j++) {
                    nums[j]=0;
                }
                return nums;
            }
        }
        int [] resu=new int[n+1];
        resu[0]=1;
        return  resu;
    }
}
