package slidingwindow;

import java.util.HashMap;

public class checkInclusion {

    public boolean check(String s1,String s2){
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int right = 0;
        int left = 0;
        int valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            //找到当前串口中满足子串的所有字符
            while(valid==need.size()){
                //如果此时子串长度 == s1的长度。那么s1的排列之一就是substr(left,right)
                if(right - left == s1.length())
                    return true;
                char d = s2.charAt(left);
                left++;
                if(window.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
