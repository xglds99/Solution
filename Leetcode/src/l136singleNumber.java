import java.util.Arrays;
import java.util.HashMap;

public class l136singleNumber {

    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     *
     * 任何数与 0异或 为任何数 0 ^ n => n
     *
     * 相同的数异或为0: n ^ n => 0
     *
     * var a = [2,3,2,4,4]
     *
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
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
