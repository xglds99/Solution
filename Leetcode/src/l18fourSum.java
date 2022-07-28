import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l18fourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = j + 1;
                int l = n - 1;
                List<Integer> list = new ArrayList<>();
                while (k < l && k < n && l <n) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                    }
                    if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }



    public static int test_1(){
        int[] nums = new int[]{1,7,3,6,5,6};
        for( int i = 0; i < nums.length; i++){
            int left = 0;
            int right = nums.length - 1;
            int leftSUm = 0;
            int rightSum = 0;
            while(left++ < i ){
                leftSUm += nums[left];

            }
            while( right-- > i) {
                rightSum += nums[right];
            }
            if( leftSUm == rightSum)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        test_1();
    }
}
