package backtrack;

import java.util.Arrays;

public class combinationSum_4 {
    /**
     * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ������� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
     *
     * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
     * ���룺nums = [1,2,3], target = 4
     * �����7
     * ���ͣ�
     * ���п��ܵ����Ϊ��
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * ��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
     * @param nums
     * @param target
     * @return
     */

    private int memo[];
    public  int combinationSum4(int []nums, int target){
        memo = new int[target + 1];
        Arrays.fill(memo, -100001);
        memo[0] = 1;
        int res = dfs(nums,target);
        return res;
    }


    public  int combinationSum4dp(int []nums, int target){
        int n = nums.length;
        int []dp = new  int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int k = 0;
            for (int num : nums) {
                if (i - num < 0) continue;
                k += dp[i - num];
            }
            dp[i] = Math.max(dp[i], k);
        }
        return dp[target];
    }
    /**
     * dfs�������� ���Ŀ���Ϊtarget����ϸ���
     * @param nums
     * @param target
     * @return
     */
    public  int dfs(int []nums, int target){
        int res = 0;
       if (memo[target] != -10001) return memo[target];
       if (target == 0)return 1;
       for (int num: nums){
           if (target - num < 0) continue;
           res += dfs(nums, target - num);
       }
       memo[target] = res;
        return res;
    }


}
