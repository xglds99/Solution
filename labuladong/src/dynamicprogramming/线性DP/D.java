package dynamicprogramming.ÏßÐÔDP;

public class D {
    public int paintWalls(int[] cost, int[] time) {
        int[] dp = new int[cost.length + 1];
        for (int i = 1; i <= cost.length; i++) {
            dp[i] = 1000000000;
        }
        for (int i = 0; i < cost.length; i++) {
            for (int j = cost.length - 1; j >= 0; j--) {
                dp[j + 1] = Math.min(dp[j + 1], dp[Math.max(0, j - time[i])] + cost[i]);
            }
        }
        return dp[cost.length];
    }
}
