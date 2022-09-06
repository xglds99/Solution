import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l828uniqueLetterString {


    /**
     * 对每一个字符i，向前找到相同的字符j，向后找到相同的字符k。当前字符对最终结果的贡献是：（i-j）*(k-i)。
     * 这相当于两种方案的拼接：在字符串A（j到i）当中，字符i贡献的次数是（i-j）次。在字符串B(k-i)当中，字符i贡献的次数是（k-i）。
     * 那么当两者拼接的时候，字符i对子串（j到k）的贡献就是两种方案的乘积（符合乘法公式）。
     * @param s
     * @return
     */
    public int uniqueLetterString(String s){
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    public int uniqueLetterString_1(String s) {
        // 统计每一个字符的贡献值————该字符左边影响的唯一子串数 * 该字符右边影响的唯一子串数
        int n = s.length();
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i = 0; i < n; i++){
            int left = i - 1, right = i + 1;
            while(left >= 0 && chs[left] != chs[i]) left--; // 从当前字符的索引向左找相同字符位置left
            while(right < n && chs[right] != chs[i]) right++; // 。。。向右找相同字符的位置right
            res += (i - left) * (right - i);
        }
        return res;
    }

    @Test
    public void test(){
        String s = "LIVECODE";
        System.out.println(uniqueLetterString(s));
    }
}
