/**
 * @ClassName l238
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 9:32
 * @Version 1.0
 */
public class l238 {
    /**
     * ����һ���������� nums������ ���� answer ������ answer[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻� ��
     *
     * ��Ŀ���� ��֤ ���� nums֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺�ĳ˻�����  32 λ ������Χ�ڡ�
     *
     * �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []prefix = new int[n];
        int []suffix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n ; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0 ; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        int []res =  new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}
