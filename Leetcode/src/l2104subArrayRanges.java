import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class l2104subArrayRanges {
    /*
    给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。

返回 nums 中 所有 子数组范围的 和 。

子数组是数组中一个连续 非空 的元素序列。

     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println((double)( 1/2));
        System.out.println((double) 2/5);
    }
/*
首先用双循环来遍历所有子数组，遍历的时候得到子数组的最大值与最小值，并计算最大值与最小值的差加入结果中。
 */
    public long subArrayRanges(int[] nums,int []score) {
        int [][]tmp = new int[score.length][2];
        for(int i = 0; i < score.length; i++){
            tmp[i][0] = i;
            tmp[i][1] = score[i];
        }
        Arrays.sort(tmp,(a,b)-> b[1] - a[1]);
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

}
