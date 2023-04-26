import org.junit.Test;

/**
 * @author xgl
 * @date 2023/4/26 8:56
 */
public class l1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int []preSuffix = new int[n + 1];
        for(int i = 1; i <= n; i++){
            preSuffix[i] = preSuffix[i - 1] + nums[i - 1];

        }
        int res = 0;
        for(int i = firstLen - 1; i < n; i++){
            int curf = 0;
            curf = preSuffix[i + 1] - preSuffix[i + 1 - firstLen];
            int curs = 0;
            for(int j = i + 1 + secondLen; j < n; j++ ){
                curs = preSuffix[j + 1] - preSuffix[j + 1 - secondLen];
                res = Math.max(res, curs + curf);
            }
        }
        for(int i = secondLen - 1; i < n; i++){
            int curs = 0;
            curs = preSuffix[i + 1] - preSuffix[i + 1 - secondLen];
            int curf = 0;
            for(int j = i + 1 + firstLen; j < n; j++ ){
                curf = preSuffix[j + 1] - preSuffix[j + 1 - firstLen];
                res = Math.max(res, curs + curf);
            }
        }
        return res;
    }

    @Test
    public void test(){
        maxSumTwoNoOverlap(new int[]{1, 0, 3}, 1, 2);
    }
}
