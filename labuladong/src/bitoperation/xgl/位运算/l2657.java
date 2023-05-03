package bitoperation.xgl.λ����;

/**
 * @author xgl
 * @date 2023/5/3 9:53
 */
public class l2657 {
    /**
    * @Author xgl
    * @Description ����A��B��ǰ׺��������
     * ʹ��λ���㽫A��B���Գ��ֵ�����Ϊ���ӳ�䵽64λ�����Ķ����Ʊ�ʾ������������ ���ɼ����������ǰ׺����
    * @Date 9:53 2023/5/3
    * @Param [A, B]
    * @return int[]
    **/
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long s = 0L;
        long t = 0L;

        int [] ans = new int[A.length];
        for (int i = 0; i < A.length; i++){
            s |= 1L << A[i];
            t |= 1L << B[i];
            //������������ж��ٸ�1
            ans[i] = Long.bitCount((s & t));
        }
    return ans;
    }
}
