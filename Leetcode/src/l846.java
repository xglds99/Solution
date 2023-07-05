import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ClassName l846
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/5 20:15
 * @Version 1.0
 */
public class l846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int h: hand){
            map.put(h, map.getOrDefault(h,0) + 1);
        }
        while(!map.isEmpty()){
            Integer key = map.firstKey();
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0)map.remove(key);
            int k = groupSize - 1;
            while(map.containsKey(key + 1)){
                key+=1;
                map.put(key,map.get(key) - 1);
                if (map.get(key) == 0)map.remove(key);
                k--;
            }
            if (k != 0)return false;
        }
        return true;
    }
}
