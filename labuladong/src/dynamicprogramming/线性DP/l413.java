package dynamicprogramming.ÏßÐÔDP;

public class l413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int d = nums[j + 1] - nums[j];
                boolean f = true;
                for (int k = j; k < k + i - 1; k++) {
                    if (nums[k + 1] - nums[k] != d) {
                        f = false;
                        break;
                    }
                }
                if (f) res++;
            }
        }
        return res;
    }
}
