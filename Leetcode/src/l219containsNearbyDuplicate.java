import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class l219containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])){
//                return true;
//            }
//            set.add(nums[i]);
//            if (set.size() >= k ){
//                set.remove(nums[i - k - 1]);
//            }
//        }
//        return false;

//        for(int i = 0, j = 0; i < nums.length;){
//            if(i - j > k){
//                j = j + 1;
//                i = j + 1;
//            }
//            if(i != j && i - j <= k && nums[i] == nums[j])
//                return true;
//            System.out.println(nums[i] + " " + nums[j]);
//            if(i == nums.length - 1){
//                j = j + 1;
//                i = j + 1;
//            }else {
//                i++;
//            }
//        }
//        return false;
    }
}
