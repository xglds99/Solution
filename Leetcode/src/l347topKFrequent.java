import java.util.*;

public class l347topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int j = 0;
        int []res = new int[k];
        for(Map.Entry<Integer, Integer> entry : list){
            if(j == k)
                break;
            res[j++] = entry.getKey();
        }
        return res;
    }
}
