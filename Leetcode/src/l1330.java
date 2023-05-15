/**
 * @author xgl
 * @date 2023/5/12 9:55
 */
public class l1330 {

    public int maxValueAfterReverse(int[] nums) {
        int base = 0, d = 0, n = nums.length;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int e = Math.abs(a - b);
            base += e;
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.min(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - e,
                    Math.abs(nums[n - 1] - a) - e));
        }
        return base + Math.max(d, 2 * (mx - mn));
    }
}
