import java.util.Arrays;
import java.util.Formattable;

public class l915 {
    /**
     *����һ������ nums �����仮��Ϊ�������������� left �� right�� ʹ�ã�
     * left �е�ÿ��Ԫ�ض�С�ڻ���� right �е�ÿ��Ԫ�ء�
     * left �� right ���Ƿǿյġ�
     * left �ĳ���Ҫ������С��
     * ����������ķ���󷵻� left �� ���� ��
     * �������Ա�֤���������Ļ��ַ�����
     *
     *
     * �㷨˼�룺
     * �ҷֽ��ߣ��������ֵ <=  �Ҳ����Сֵ
     * ���α��� �������Ҳ����Сֵʹ�ö�̬�滮��˼��������
     * ������ֽ��߸��������
     * ����ÿ��λ�����Ҳ����Сֵ�������䱾��
     * ������ҵ�ÿ��λ�õ��������ֵx����һ��λ�õ��Ҳ����Сֵ���бȽ�y
     * ������ x <= y
     * �򷵻�x��λ��+1��
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightmins = new int[n];
        rightmins[n - 1] = nums[n - 1];
        int mn = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmins[i] = Math.min(rightmins[i + 1], nums[i]);
        }
        int mx = -11111;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            if (mx <= rightmins[i + 1]) return i + 1;
        }
        return -1;
    }
}
