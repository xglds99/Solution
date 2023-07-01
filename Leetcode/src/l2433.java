/**
 * @author xgl
 * @date 2023/6/26 20:36
 */
public class l2433 {
    /**
    * @Author xgl
    * @Description
     * ����һ������Ϊ n �� ���� ���� pref ���ҳ��������������������ҳ���Ϊ n ������ arr ��
     *
     * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
     * ע�� ^ ��ʾ ��λ���bitwise-xor�����㡣
     * ��Ϊ pref[i] = pref[i - 1] ^ arr[i]
     * pref[i - 1] ^ pref[i]= pref[i - 1] ^ arr[i] ^ pref[i - 1]
     * ����pref[i - 1] ^ pref[i] = arr[i]
     * ����֤������ Ψһ �ġ�
    * @Date 20:37 2023/6/26
    * @Param [pref]
    * @return int[]
    **/
    public int []findArray(int []pref){
        int n = pref.length;
        int []res = new int[n];
        res[0] = pref[0];
        for (int i = 1; i < n; i++) {
            res[i] = pref[i] ^ pref[i - 1];
        }
        return res;
    }
}
