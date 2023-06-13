import java.util.Arrays;

public class l1658 {


    /**
     * ����˼ά ��������
     * ��������� subnums �ĺ� target = sum - x;
     * ��Ҫ�����ٲ����� k = n - subnums.length;
     * ��ָ��ѭ�����ҿ�ʼ�ӣ�����ʹ��� target, ��ָ�������ƶ�
     * if sum == target ���´� res��ע���ʱ�������������sum == target
     * ��Ҫ����С������ k = n - res
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num :nums) target += num;
        if (target < 0) return  -1;
        int res = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++];
            if (sum == target) res = Math.max(res, right - left + 1);
        }
        return res < 0 ? -1 : n - res;
    }
}
