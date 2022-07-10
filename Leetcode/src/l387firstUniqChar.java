import org.junit.Test;

import java.util.HashMap;

public class l387firstUniqChar {
    @Test
    public void test(){
        String s="loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0 ;i<s.length(); i++){
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
