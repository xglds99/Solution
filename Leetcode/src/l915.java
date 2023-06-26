import java.util.Arrays;
import java.util.Formattable;

public class l915 {
    /**
     *给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     * 在完成这样的分组后返回 left 的 长度 。
     * 用例可以保证存在这样的划分方法。
     *
     *
     * 算法思想：
     * 找分界线，左侧的最大值 <=  右侧的最小值
     * 两次遍历 首先找右侧的最小值使用动态规划的思想来做。
     * 找这个分界线该如何找呢
     * 遍历每个位置其右侧的最小值都包括其本身，
     * 从左侧找到每个位置的左侧的最大值x与下一个位置的右侧的最小值进行比较y
     * 若满足 x <= y
     * 则返回x的位置+1；
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightmins = new int[n];
        rightmins[n - 1] = nums[n - 1];
        int mn = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmins[i] = Math.min(rightmins[i + 1], nums[i]);
        }
        int mx = -11111;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            if (mx <= rightmins[i + 1]) return i + 1;
        }
        return -1;
    }
}
