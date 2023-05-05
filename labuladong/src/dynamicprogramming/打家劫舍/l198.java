package dynamicprogramming.��ҽ���;

/**
 * @author xgl
 * @date 2023/5/4 14:28
 */
public class l198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n + 1];//dp[i]͵����iΪ���һ������ֵ
        int mx =  0;
        for(int i = 0; i < n; i++){
            dp[i] = nums[i];
            for(int j = 0; j <= i -2; j++){
                dp[i] = Math.max(dp[i],dp[j] + nums[i]);
            }
            mx = Math.max(mx, dp[i]);
        }
        return mx;
    }

}
