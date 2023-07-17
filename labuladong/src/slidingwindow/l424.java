package slidingwindow;

import java.util.HashMap;

/**
 * @ClassName l424
 * @Description
 * @Author xgl
 * @Date 2023/7/17 19:23
 * @Version 1.0
 */
public class l424 {
    public int characterReplacement(String s, int k){
        int []map = new int[26];
        int n = s.length();
        int i = 0, j = 0;
        int maxCount = 0;
        while(i < n){
            char c = s.charAt(i);
            map[c- 'A']++;
            maxCount = Math.max(maxCount, map[c-'A']);
            if((i - j + 1) - maxCount > k){
                map[s.charAt(j)-'A']--;
                j++;
            }
            i++;
        }
        return i - j;
    }
}
