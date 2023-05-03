package bitoperation.xgl.位运算;

/**
 * @author xgl
 * @date 2023/5/3 9:53
 */
public class l2657 {
    /**
    * @Author xgl
    * @Description 计算A和B的前缀公共数组
     * 使用位运算将A和B中以出现的数字为编号映射到64位整数的二进制表示，两个数相与 即可计算出公共的前缀数组
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
            //计算二进制数有多少个1
            ans[i] = Long.bitCount((s & t));
        }
    return ans;
    }
}
