public class l287findDuplicate {
    /*
    给定一个n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。

     */
    public static void main(String[] args) {
        int[] nums =new int[]{6,6,6,6};
        System.out.println(findDuplicate(nums));
    }

    public  static  int findDuplicate(int[] nums){
        int[] map = new int[nums.length +1];
        int res = 0;
        for (int num : nums) {
            if (map[num] != 0) {
                res = num;
            }
            map[num]++;
        }
        return res;
    }
}
