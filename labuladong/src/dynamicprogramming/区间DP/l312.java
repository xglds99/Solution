package dynamicprogramming.区间DP;

/**
 * @author xgl
 * @date 2023/5/15 19:19
 */
public class l312 {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            //1.定义dp数组的含义
            int [][]dp = new int[n + 2][n + 2];
            int []nn = new int[n + 2];
            nn[0] = 1;
            nn[n + 1] = 1;
            System.arraycopy(nums, 0, nn, 1, n);
            for(int i = n - 1; i >= 0; i--){
                for(int j = i + 2; j <=n + 1 ;j++){
                    for(int k = i + 1; k < j; k++){
                        int sum = dp[i][k] + dp[k][j] + nn[k] * nn[i] * nn[j];
                        dp[i][j] = Math.max(dp[i][j], sum);
                    }
                }
            }
            return dp[0][n + 1];
        }
}
