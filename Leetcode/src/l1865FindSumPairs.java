import java.util.HashMap;
import java.util.Map;

public class l1865FindSumPairs {


}

class FindSumPairs {
    int arrys1[];
    int arrys2[];
    Map<Integer, Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        arrys1 = nums1;
        arrys2 = nums2;
        map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(arrys2[i], map.getOrDefault(map.get(arrys1[i]), 0) + 1);
        }
    }

    public void add(int index, int val) {
        int n=arrys2[index];
        map.put(n,map.get(n)-1);
        arrys2[index]+=val;
        map.put(arrys2[index],map.getOrDefault(arrys2[index],0)+1);
    }
    public int count(int tot) {
        int sum = 0;
        for (int i = 0; i < arrys1.length; i++) {
          sum+=map.getOrDefault(tot-arrys1[i],0);
        }
        return sum;
    }
}

