package greedy;

/**
 * @author xgl
 * @date 2023/6/28 9:25
 */
public class l409 {
    public int longestPalindrome(String s){
        char[] cs = s.toCharArray();
        int [] map = new int[60];
        for (char c : cs) {
            if (Character.isLowerCase(c)) {
                map[c - 'a']++;
            } else {
                map[c - 'A' + 26]++;
            }
        }

        int res = 0;
        for (int i = 0; i < 60; i++) {
            res += map[i] / 2 * 2;
            if (map[i] % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
