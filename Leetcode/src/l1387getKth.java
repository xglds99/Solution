import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class l1387getKth {


    public int getKth(int lo, int hi, int k) {
        int [][]res = new int[lo - hi + 1][2];
        for(int i = lo ; i <= hi ;i++){
            res[i - lo][0] = get(i);
            res[i - lo][1] = i;
        }
        Arrays.sort(res, (a,b) ->{
            if (a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        return res[k - 1][1];
    }

    public int getKth_1(int lo, int hi, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = lo ; i <= hi ;i++){
            map.put(i, get(i));
        }
        Integer [] nums = new Integer[hi - lo + 1];
        for (int i = 0; i < hi - lo + 1; i++){
            nums[i] = map.get(i + lo);
        }
        Arrays.sort(nums, (a,b) -> get(a).equals(get(b)) ? b - a : get(a) - get(b));
        for(int s : nums){
            System.out.println(s);
        }

        return 0;
    }

    public Integer get(int x){
        int i = 0;
        while(x != 1){
            if(x % 2 == 0)
                x = x / 2;
            else
                x = x * 3 + 1;
            i++;
        }
        return i;
    }
}
