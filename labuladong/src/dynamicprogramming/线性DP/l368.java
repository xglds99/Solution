package dynamicprogramming.����DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xgl
 * @date 2023/5/30 11:06
 */
public class l368 {

    /***
    * @Author xgl
    * @Description
     * ����һ���� ���ظ� ��������ɵļ��� nums �������ҳ��������������������Ӽ� answer ���Ӽ���ÿһԪ�ض� (answer[i], answer[j]) ��Ӧ�����㣺
     * answer[i] % answer[j] == 0 ����
     * answer[j] % answer[i] == 0
     * ������ڶ����Ч���Ӽ������������κ�һ�����ɡ�
     *
     * //���������������ͬ��������Ҫ�Ƚϵ��� nums[i] % nums[j] == 0
    * @Date 11:08 2023/5/30
    * @Param [nums]
    * @return List<Integer>
    **/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int mxLen = 0;
        int mxIndex = -1;
        //1.dp���鶨�壬dp[i]Ϊ��iΪ��β����Ӽ����ȡ�
        int [] dp = new int[n + 10];
        //��ΪҪ��¼��Ӽ������Զ���ǰһ���±�����飬�Ͳ��鼯���ơ�
        int [] prev = new int[n + 10];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //�����֮ǰ���±�����������
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    //i��ǰһ���������j
                    prev[i] = j;
                }
                if (dp[i] > mxLen) {
                    //������Ӽ��ĳ���
                    mxLen = dp[i];
                    //������iΪ��β����Ӽ����±�
                    mxIndex = i;
                }
            }
        }
        //���ղ��鼯��һֱ��������ͨ�����ϵĵ���뵽���У�
        while (mxIndex != -1){
            ans.add(nums[mxIndex]);
            mxIndex = prev[mxIndex];
        }
        return ans;
    }
}
