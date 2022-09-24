import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class l1636frequencySort {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] sort = new Integer[nums.length];
        for (int i = 0; i < sort.length; i++) {
            sort[i] = nums[i];
        }
        //Arrays.sort(sort, (o1, o2) -> map.get(o1) - map.get(o2) > 0 ? map.get(o1) - map.get(o2) : o2 - o1);
        Arrays.sort(sort, (a, b) -> map.get(a) - map.get(b) == 0 ? b - a : map.get(a) - map.get(b));
        for (int i = 0; i < sort.length; i++) {
            nums[i] = sort[i];
        }
        return nums;
    }
}
