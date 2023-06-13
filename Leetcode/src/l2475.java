import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Collections;
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
}
