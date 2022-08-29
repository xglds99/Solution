public class l1470shuffle {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] ans = new int[n << 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                ans[index++] = nums[i];
                ans[index++] = nums[n + i];
            }
            return ans;
        }
    }
}
