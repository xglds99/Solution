public class l268missingNumber {
    public static void main(String[] args) {
        int []nums={1,2,3,4,5,6,7,9,0};
        System.out.println(missingNumber1(nums));
    }

    public  static  int missingNumber(int nums[]){
        boolean isFlag;
        int i=0;
        for(;i< nums.length+1;i++){
         isFlag=false;
            for(int j=0;j< nums.length;j++){
                if(i==nums[j]){
                    isFlag =true;
                }
            }
            if(!isFlag){
              break;
            }
        }
        return  i;
    }

    public  static  int missingNumber1(int nums[]){
        int sum=0;
        int resu=0;
        for(int i=0;i< nums.length;i++){
            sum+=i;
            resu+=nums[i];
        }
        return (sum+(nums.length)-(resu));
    }
}
