public class l801minSwap {


    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];//dp数组定义，dp[i][j]代表在i位置,j = 0代表不互换，1互换，累计的交换次数。
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 如果i【不互换】，则i-1可【互换】也可【不互换】
                dp[i][1] = dp[i][0] + 1; // 如果i【互换】，则i-1可【互换】也可【不互换】
            } else if (a1 < a2 && b1 < b2) {
                dp[i][0] = dp[i - 1][0]; // 如果i【不互换】，则i-1必须【不互换】
                dp[i][1] = dp[i - 1][1] + 1; // 如果i【互换】，则i-1必须【互换】
            } else {
                dp[i][0] = dp[i - 1][1]; // 如果i【不互换】，则i-1必须【互换】
                dp[i][1] = dp[i - 1][0] + 1; // 如果i【互换】，则i-1必须【不互换】
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }

}
