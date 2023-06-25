package greedy;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * @author xgl
 * @date 2023/6/25 11:02
 */
public class C {
    private int MOD = (int)1e9 + 7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                list.add(i);
                cnt1++;
            }
        }
        if (cnt1 == 0) return 0;
        if (cnt1 == 1)return 1;
        long res = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            int start = list.get(i);
            res = (res * (list.get(i) - list.get(i - 1)) % MOD) % MOD;
        }

        return (int) (res % MOD);

    }
}
