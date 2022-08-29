import java.util.Arrays;
import java.util.HashMap;

public class l136singleNumber {

    /**
     * �����ɣ�a ^ b ^ c <=> a ^ c ^ b
     *
     * �κ����� 0��� Ϊ�κ��� 0 ^ n => n
     *
     * ��ͬ�������Ϊ0: n ^ n => 0
     *
     * var a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4�ȼ��� 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     * @param nums
     * @return
     */

    public static int singleNumber_1(int []nums){
        int [] resu = new int[2];
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
