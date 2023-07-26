package slidingwindow;

/**
 * @ClassName l2730
 * @Description
 * @Author xgl
 * @Date 2023/7/18 15:24
 * @Version 1.0
 */
public class l2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int i = 1, j = 0;
        int n = s.length();
        int same = 0;
        int res = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                same++;
                if (same > 1) {
                    j++;
                    while (s.charAt(j) != s.charAt(j - 1)) {
                        j++;
                    }
                    same--;
                }
            }
            res = Math.max(res, i - j + 1);
            i++;
        }
        return res;
    }
}
