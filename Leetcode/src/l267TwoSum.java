public class l267TwoSum {
    /*
    给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。


     */
    public static void main(String[] args) {
    int nums[]=new int[]{-1,0,0,1};
        int[] sum = new l267TwoSum().twoSum(nums, 0);
        for(int t:sum){
            System.out.println(t);
        }
    }
    public   int []twoSum(int nums[],int target){
        int []resu=new int[2];
        int fast=0;
        int slow=0;
        for (;slow< nums.length-1;slow++){
            for(fast=slow+1;fast<nums.length;fast++){

                if(nums[fast]+nums[slow]==target){
                    resu[0]=slow+1;
                    resu[1]=fast+1;
                }
            }
        }
        return resu;
    }
}
