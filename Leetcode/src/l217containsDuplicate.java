import java.util.HashMap;
import java.util.LinkedHashMap;

public class l217containsDuplicate {

    public boolean containsDuplicate(int nums[]){
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
              hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1 );
        }
        for(Integer i: hashMap.keySet()){
            if(i>2){
                return true;
            }
        }
        return false;
    }
}
