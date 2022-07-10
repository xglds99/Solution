import java.util.HashMap;

public class l217containsDuplicate {

    public boolean containsDuplicate(int nums[]){
        HashMap<Integer, Integer> hashMap=new HashMap<>();
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
