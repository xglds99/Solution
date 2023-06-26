import java.util.Arrays;

public class l453 {

    /**
     *����һ������Ϊ n ���������飬ÿ�β�������ʹ n - 1 ��Ԫ������ 1 ����������������Ԫ����ȵ���С����������
     *����˼ά��ÿ�β�������ʹ n - 1 ��Ԫ������ 1 �ȼ��� ÿ�β�����ʹ 1 ��Ԫ�ؼ��� 1
     * ���Ȼ�ȡ��������Сֵ������ʣ��Ԫ������Сֵ�Ĳ��ͼ�Ϊ��
     *
     * @param nums
     * @return
     */
    public int minMoves(int []nums){
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return   res;
    }
}
