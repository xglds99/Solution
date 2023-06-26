import java.util.Arrays;

public class l453 {

    /**
     *给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
     *逆向思维：每次操作将会使 n - 1 个元素增加 1 等价于 每次操作会使 1 个元素减少 1
     * 首先获取数组中最小值，计算剩余元素与最小值的差，求和即为答案
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
