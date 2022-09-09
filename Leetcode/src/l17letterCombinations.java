import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class l17letterCombinations {
    List<String> resu = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits){
        if (digits.length() == 0)
            return resu;
        HashMap<Character, String> ctop = new HashMap<>();
        ctop.put('2',"abc");
        ctop.put('3',"def");
        ctop.put('4',"ghi");
        ctop.put('5',"jkl");
        ctop.put('6',"mno");
        ctop.put('7',"pqrs");
        ctop.put('8',"tuv");
        ctop.put('9',"wxyz");
       dfs(ctop,digits,0,sb);
       return  resu;
    }
    void dfs(HashMap<Character,String> ctop,String digits,int start,StringBuilder track){
        if(start == digits.length()){
            resu.add(track.toString());
        }else {
            char c = digits.charAt(start);
            String s = ctop.get(c);
            for (int i = 0; i < s.length(); i++) {
                track.append(s.charAt(i));
                dfs(ctop, digits, start + 1, track);
                track.deleteCharAt(start);
            }
        }
    }
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }

}
