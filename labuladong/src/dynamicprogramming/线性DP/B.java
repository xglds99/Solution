package dynamicprogramming.ÏßÐÔDP;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class B {
    public int findValueOfPartition(int[] nums) {
        if (nums.length == 2)return  Math.abs(nums[0] - nums[1]);
        Arrays.sort(nums);
        int n = nums.length;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int k = nums[i + 1] - nums[i];
            if (k <mn)mn = k;
        }
    return mn;
    }
}
