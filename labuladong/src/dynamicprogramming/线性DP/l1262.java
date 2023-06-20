package dynamicprogramming.ÏßÐÔDP;

public class l1262 {
    public int maxSumDivisibleByThree(int []nums){
        int n = nums.length;
        int [][] dp = new int[n + 10][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][(j + nums[i - 1]) % 3] + nums[i - 1]);
                }
            }
        return  dp[n][0];
    }
}
