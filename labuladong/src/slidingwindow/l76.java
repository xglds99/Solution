package slidingwindow;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName l76
 * @Description
 * @Author xgl
 * @Date 2023/7/22 21:58
 * @Version 1.0
 */
public class l76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int j = 0, n = s.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for(char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))valid++;
            }
            while(valid == need.size()){
                if (i - j + 1 < minLen){
                    start = j;
                    minLen = i - j + 1;
                }
                char d = s.charAt(j);
                j++;
                if (window.containsKey(d)){
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) == 0)window.remove(d);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
