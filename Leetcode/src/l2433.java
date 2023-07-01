/**
 * @author xgl
 * @date 2023/6/26 20:36
 */
public class l2433 {
    /**
    * @Author xgl
    * @Description
     * 给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
     *
     * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
     * 注意 ^ 表示 按位异或（bitwise-xor）运算。
     * 因为 pref[i] = pref[i - 1] ^ arr[i]
     * pref[i - 1] ^ pref[i]= pref[i - 1] ^ arr[i] ^ pref[i - 1]
     * 所以pref[i - 1] ^ pref[i] = arr[i]
     * 可以证明答案是 唯一 的。
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
