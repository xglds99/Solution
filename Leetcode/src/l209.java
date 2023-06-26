/**
 * @ClassName l209
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 10:14
 * @Version 1.0
 */
public class l209 {
    /**
     * ����һ������ n ���������������һ�������� target ��
     *
     * �ҳ���������������� �� target �ĳ�����С�� ���������� [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ���������ڷ��������������飬���� 0 ��
     *
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int cur = 0;
        int n = nums.length;
        int res = n + 1;
        while(i < n && j < n){
            cur+= nums[i];
            while(j < n && cur >= target){
                res = Math.min(i - j + 1,res);
                cur -= nums[j];
                j++;
            }
            i++;
        }
        return res == n + 1 ? 0 : res;
    }
}
