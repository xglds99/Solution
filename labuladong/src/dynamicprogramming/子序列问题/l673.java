package dynamicprogramming.����������;

public class l673 {
    /**
     * ����һ��δ������������� nums �� ��������������еĸ��� ��
     * <p>
     * ע�� ������б����� �ϸ� �����ġ�
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int res = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (nums[j] + 1 > nums[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; //����������г��ִ���
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = cnt[i];
            } else if (dp[i] == maxLen) {
                res += cnt[i];
            }

        }
        return res;
    }
}
