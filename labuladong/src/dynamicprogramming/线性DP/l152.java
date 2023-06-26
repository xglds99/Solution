package dynamicprogramming.����DP;

/**
 * @ClassName l152
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 8:59
 * @Version 1.0
 */
public class l152 {
    /**
     * ����������������һ���������㵱ǰλ�õ����Ž������ǰһ��λ��ת�Ƶõ�
     * Ҫ��õ���ǰλ�õ����ֵ����Ҫ��ǰһ��λ�õ���Сֵ�� ���бȽ�
     * ���ǵ�ǰλ�������һ�������Ļ�����ô����ϣ������ǰһ��λ�ý�β��ĳ���εĻ�Ҳ�Ǹ������������Ϳ��Ը���������
     * ��������ϣ������������ܡ����ø��ࡹ����������С��
     * �����ǰλ����һ�������Ļ������Ǹ�ϣ������ǰһ��λ�ý�β��ĳ���εĻ�Ҳ�Ǹ�����������ϣ���������ܵش�
     * ����ʾ�Ե� i ��Ԫ�ؽ�β�ĳ˻���С������ĳ˻�����ô���ǿ��Եõ������Ķ�̬�滮ת�Ʒ��̣�
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        System.arraycopy(nums, 0, minDp, 0, n);
        System.arraycopy(nums, 0, maxDp, 0, n);
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(maxDp[i - 1] * nums[i], nums[i]));
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
