/**
 * @author xgl
 * @date 2023/6/27 13:06
 */
public class L2321 {
    public int maximumsSplicedArray(int[] a, int[] b) {
        return Math.max(maxSubArray(a,b), maxSubArray(b,a));
    }


    public int maxSubArray(int []a,int []b){
        int n = a.length;
        int []d = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            d[i] = b[i] - a[i];
        }
        int []dp = new int[n + 1];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + d[i];
            res = Math.max(res, dp[i]);
        }
        return res + sum;
    }
}
