public class l35searchInsert {
    public static void main(String[] args) {
        int[] numsp ={1,2,3,6,7,9};
        System.out.println(searchInsert(numsp,5));
    }
    public static  int searchInsert(int[] nums, int target){
        int left=0;
        int right= nums.length-1;
        while(left< right){
            int mid=(left + right) >> 2;
            if(target==nums[mid]){
                return mid;
            }
            else  if(target<nums[mid]){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
}
