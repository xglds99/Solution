import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class l2475 {

    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0, start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]){
                res += start * (i - start + 1) * (n - 1 -i);
                start = i + 1;
            }
        }
        return res;
    }

    public int unequalTriplets_1(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.
                        groupingBy(i -> i, Collectors.counting()));
        int res = 0, a =0, c = nums.length;
        for (var entry: map.entrySet()){
            int b = Math.toIntExact(entry.getValue());
            c -= b;
            res += a * b * c;
            a += b;
        }
        return res;
    }
}
