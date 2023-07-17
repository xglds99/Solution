/**
 * @ClassName l2772
 * @Description
 * @Author xgl
 * @Date 2023/7/10 14:31
 * @Version 1.0
 */
public class l2772 {
    public boolean checkArray(int[] nums, int k) {
        int curr = 0, count[] = new int[nums.length + k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < (curr -= count[i]) || nums[i] > curr && i + k > nums.length) {
                return false;
            }
            curr += count[i + k] = nums[i] - curr;
        }
        return true;
    }
}
