public class l801minSwap {


    public int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];//dp���鶨�壬dp[i][j]������iλ��,j = 0����������1�������ۼƵĽ���������
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // ���i��������������i-1�ɡ�������Ҳ�ɡ���������
                dp[i][1] = dp[i][0] + 1; // ���i������������i-1�ɡ�������Ҳ�ɡ���������
            } else if (a1 < a2 && b1 < b2) {
                dp[i][0] = dp[i - 1][0]; // ���i��������������i-1���롾��������
                dp[i][1] = dp[i - 1][1] + 1; // ���i������������i-1���롾������
            } else {
                dp[i][0] = dp[i - 1][1]; // ���i��������������i-1���롾������
                dp[i][1] = dp[i - 1][0] + 1; // ���i������������i-1���롾��������
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }

}
