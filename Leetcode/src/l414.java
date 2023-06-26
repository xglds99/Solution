import java.util.Arrays;

/**
 * @author xgl
 * @date 2023/6/26 17:02
 */
public class l414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length - 1];
        int i = nums.length - 1;
        int cur = res;
        int cnt = 1;
        while (i >= 0) {
            if (nums[i] < cur) {
                cur = nums[i];
                cnt++;
            }
            i--;
            if (cnt == 3)return cur;
        }
        return res;
    }
}
