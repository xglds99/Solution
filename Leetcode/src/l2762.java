import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ClassName l2762
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/3 16:28
 * @Version 1.0
 */
public class l2762 {

    public long continuousSubarrays(int[] nums) {
        long res = 0L;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }

            res += i - j + 1;
            i++;
        }

        return res;
    }

//    static {
//        long count = 0;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        Integer[] nums = new Integer[99];
//        for (int i = 0, j = 0; j < nums.length; j++) {
//            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
//            for (; map.lastKey() - map.firstKey() > 2; i++) {
//                map.put(nums[i], map.get(nums[i]) - 1);
//                if (map.get(nums[i]) == 0) {
//                    map.remove(nums[i]);
//                }
//            }
//            count += j - i + 1;
//        }
//
//    }

}
