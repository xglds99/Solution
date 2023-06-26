import java.util.HashSet;

/**
 * @ClassName l3
 * @Description TODO
 * @Author xgl
 * @Date 2023/6/24 11:09
 * @Version 1.0
 */
public class l3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        while(i < n && j < n){
            while(j < n && set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            res = Math.max(res, i - j + 1);
            i++;
        }
        return res;
    }
}
